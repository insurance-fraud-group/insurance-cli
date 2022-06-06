package service;

import domain.Accident;
import domain.Adjust;
import domain.Dispatch;
import domain.enums.ProcessState;
import java.util.List;

public interface AdjusterService {

  List<Accident> searchAccident(ProcessState processState);

  Dispatch getDispatch(Accident accident);

  void registerAdjust(Adjust adjust);

  List<Adjust> searchPendingAdjust();

  void updateAdjust(Adjust adjust);
}
