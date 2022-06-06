package service.impl;

import domain.Accident;
import domain.Adjust;
import domain.Dispatch;
import domain.enums.ProcessState;
import java.util.List;
import java.util.stream.Collectors;
import repository.AccidentRepository;
import repository.AdjustRepository;
import repository.DispatchRepository;
import repository.TransactionRepository;
import service.AdjusterService;

public class AdjusterServiceImpl implements AdjusterService {

  private AccidentRepository accidentRepository;
  private DispatchRepository dispatchRepository;
  private AdjustRepository adjustRepository;
  private TransactionRepository transactionRepository;

  public AdjusterServiceImpl() {
    accidentRepository = new AccidentRepository();
    dispatchRepository = new DispatchRepository();
    adjustRepository = new AdjustRepository();
    transactionRepository = new TransactionRepository();
  }

  @Override
  public List<Accident> searchAccident(ProcessState processState) {
    return accidentRepository.findAll().stream()
        .filter(accident -> accident.getProcessState() == processState)
        .collect(Collectors.toList());
  }

  @Override
  public Dispatch getDispatch(Accident accident) {
    return dispatchRepository.findBy("accident", accident.getId());
  }

  @Override
  public void registerAdjust(Adjust adjust) {
    Accident accident = adjust.getAccident();
    accident.setProcessState(ProcessState.INDEMNITY);
    accidentRepository.update(accident);
    adjustRepository.save(adjust);
  }

  @Override
  public List<Adjust> searchPendingAdjust() {
    return adjustRepository.findAll().stream()
        .filter(adjust -> adjust.getAccident().getProcessState() == ProcessState.INDEMNITY)
        .filter(adjust -> adjust.isIndemnity() == true)
        .collect(Collectors.toList());
  }

  @Override
  public void updateAdjust(Adjust adjust) {
    adjust.getAccident().setProcessState(ProcessState.ADJUST);
    adjustRepository.update(adjust);
  }
}
