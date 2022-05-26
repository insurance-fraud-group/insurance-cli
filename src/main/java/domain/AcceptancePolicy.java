package domain;

import domain.employee.Employee;
import dto.AcceptancePolicyDto;
import java.util.Date;

public class AcceptancePolicy {

  private int id;
  private Date createdDate;
  private String description;
  private String name;
  private Employee writer;

  public AcceptancePolicy(AcceptancePolicyDto dto) {
    this.id = dto.getId();
    this.createdDate = dto.getCreatedDate();
    this.description = dto.getDescription();
    this.name = dto.getName();
    this.writer = dto.getWriter();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Employee getWriter() {
    return writer;
  }

  public void setWriter(Employee writer) {
    this.writer = writer;
  }

  public void update(AcceptancePolicyDto dto) {
    this.createdDate = dto.getCreatedDate();
    this.description = dto.getDescription();
    this.name = dto.getName();
    this.writer = dto.getWriter();
  }
}
