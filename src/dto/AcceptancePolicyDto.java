package dto;

import domain.employee.Employee;
import java.util.Date;

public class AcceptancePolicyDto {

  private int id;
  private Date createdDate;
  private String description;
  private String name;
  private Employee writer;

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
}
