package service.impl;

import domain.Accident;
import domain.Dispatch;
import domain.enums.ProcessState;
import java.util.List;
import java.util.stream.Collectors;
import repository.AccidentRepository;
import repository.DispatchRepository;
import service.AccidentInvestigatorService;
import utils.Session;

public class AccidentInvestigatorServiceImpl implements AccidentInvestigatorService {

  private final AccidentRepository accidentRepository;
  private final DispatchRepository dispatchRepository;

  public AccidentInvestigatorServiceImpl() {
    accidentRepository = new AccidentRepository();
    dispatchRepository = new DispatchRepository();
  }

  @Override
  public List<Accident> searchAccident(ProcessState processState) {
    return accidentRepository.findAll().stream()
        .filter(accident -> accident.getProcessState() == processState)
        .collect(Collectors.toList());
  }

  @Override
  public void receiveDispatch(Accident accident) {
    Dispatch dispatch = Dispatch.builder()
        .accident(accident)
        .accidentInvestigator(Session.getSession().getUser())
        .build();
    dispatchRepository.save(dispatch);

    accident.setProcessState(ProcessState.DISPATCH_READY);
    accidentRepository.update(accident);
  }

  @Override
  public void processAccident(Dispatch dispatch) {
    dispatchRepository.update(dispatch);
    Accident accident = dispatch.getAccident();
    accident.setProcessState(ProcessState.DISPATCH_COMPLETE);
    accidentRepository.update(accident);
  }

  @Override
  public Dispatch getDispatch(Accident accident) {
    return dispatchRepository.findBy("accident", accident.getId());
  }

  @Override
  public List<Dispatch> searchDispatch() {
    return dispatchRepository.findAll();
  }
}
