package command;

import command.menu.sales.ContractManagement;
import command.menu.sales.CustomerManagement;
import command.menu.sales.Sales;
import command.menu.sales.SalesManagement;
import command.parser.SalesParser;
import domain.Contract;
import domain.Customer;
import domain.Employee;
import domain.Insurance;
import java.util.List;
import service.impl.SalesServiceImpl;

public class SalesCommand extends Command {

  private static final SalesParser parser = SalesParser.getInstance();
  private static final SalesServiceImpl salesService = new SalesServiceImpl();

  public static void run() {
    executeCommand("영업", Sales.values());
  }

  public static void manageSales() {
    executeCommand("영업 관리", SalesManagement.values());
  }

  public static void manageInsurance() {
    String[] args = {"insuranceCode", "name", "insuranceType", "coverDescription"};
    List<Insurance> insuranceList = salesService.getInsuranceList();
    printTitle("보험 관리");
    printTable(insuranceList, args);

    Insurance insurance = insuranceList.get(input());
    printTitle("보험 정보 조회");
    printTable(insurance);
  }

  public static void manageCustomer() {
    executeCommand("고객 관리", CustomerManagement.values());
  }

  public static void searchCustomer() {
    printTitle("고객 조회");
    String[] args = {"name", "birth", "sex"};
    List<Customer> customerList = salesService.getCustomerList();
    printTable(customerList, args);

    Customer customer = customerList.get(input());

    printTitle("고객 정보 상세 조회");
    printTable(customer);
  }

  public static void signUpCustomer() {
    printTitle("신규 고객");
    Customer customer = Customer.builder()
        .accountNumber(parser.getAccountNumber())
        .address(parser.getAddress())
        .birth(parser.getBirth())
        .job(parser.getJob())
        .name(parser.getName())
        .phoneNumber(parser.getPhoneNumber())
        .sex(parser.getSex())
        .build();

    salesService.createCustomer(customer);
  }

  public static void manageOrganization() {
    printTitle("조직 관리");
    System.out.println("상세 정보를 조회할 사원을 선택해주세요.");
    List<Employee> employeeList = salesService.getEmployeeList();
    printTable(employeeList, "id", "name");

    Employee employee = employeeList.get(input());
    String[] args = {"id", "name", "email", "employeeType"};
    printTitle("사원 인적 정보");
    printTable(employee, args);
  }

  public static void manageContract() {
    executeCommand("계약 관리", ContractManagement.values());
  }

  public static void searchAllContract() {
    printTitle("모든 계약 조회");
    String[] args = {"applicationDate", "customer", "insurance"};
    List<Contract> contractList = salesService.getContractList();
    printTable(contractList, args);
    Contract contract = contractList.get(input());
    printTable(contract);
  }

  public static void searchUnsignedContract() {
    printTitle("미체결 계약 리스트");
    String[] args = {"applicationDate", "customer", "insurance"};
    List<Contract> unsignedContractList = salesService.getUnsignedContractList();
    printTable(unsignedContractList, args);

    Contract selectedContract = unsignedContractList.get(input());
    printTable(selectedContract);
    concludeContract(selectedContract);
  }

  public static void concludeContract(Contract contract) {

  }

  public static void makeContract() {

  }

  public static void managePayment() {

  }
}
