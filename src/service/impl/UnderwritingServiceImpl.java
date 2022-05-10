package service.impl;

import domain.Underwriting;
import dto.UnderwritingServiceDto;
import java.util.List;
import service.UnderwritingService;

public class UnderwritingServiceImpl implements UnderwritingService {

  private List<Underwriting> underwritingList;

  public UnderwritingServiceImpl() {

  }

  public void create(UnderwritingServiceDto dto) {
    Underwriting underwriting = new Underwriting(dto);
    underwritingList.add(underwriting);
  }

  public void delete(int id) {
    underwritingList.remove(id);
  }

  public Underwriting read(int id) {
    return underwritingList.get(id);
  }

  public void update(UnderwritingServiceDto dto) {
    int id = dto.getId();
    Underwriting underwriting = underwritingList.get(id);
    underwriting.update(dto);
  }
}
