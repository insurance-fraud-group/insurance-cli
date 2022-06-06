package service;

import domain.Accident;
import domain.Dispatch;
import domain.enums.ProcessState;
import java.util.List;

public interface AccidentInvestigatorService {

  List<Accident> searchAccident(ProcessState processState);

  void receiveDispatch(Accident accident);

  void processAccident(Dispatch dispatch);

  Dispatch getDispatch(Accident accident);

  List<Dispatch> searchDispatch();
}
