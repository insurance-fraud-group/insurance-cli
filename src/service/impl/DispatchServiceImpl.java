package service.impl;

import domain.Dispatch;
import dto.DispatchServiceDto;
import java.util.List;
import service.DispatchService;

public class DispatchServiceImpl implements DispatchService {

  private List<Dispatch> dispatchList;

  public DispatchServiceImpl() {

  }

  public void create(DispatchServiceDto dto) {
    Dispatch dispatch = new Dispatch(dto);
    dispatchList.add(dispatch);
  }

  public void delete(int id) {
    dispatchList.remove(id);
  }

  public Dispatch read(int id) {
    return dispatchList.get(id);
  }

  public void update(DispatchServiceDto dto) {
    int id = dto.getId();
    Dispatch dispatch = dispatchList.get(id);
    dispatch.update(dto);
  }
}
