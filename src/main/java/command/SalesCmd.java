package command;

import command.menu.sales.ContractManagement;
import command.menu.sales.ContractProgress;
import command.menu.sales.CustomerManagement;
import command.menu.sales.Sales;
import command.menu.sales.SalesManagement;
import command.parser.SalesParser;
import domain.Contract;
import domain.Customer;
import domain.Insurance;
import domain.Transaction;
import domain.User;
import java.util.Arrays;
import java.util.List;
import service.impl.SalesServiceImpl;

public class SalesCmd extends Command {

  private static final SalesParser parser = SalesParser.getInstance();
  private static final SalesServiceImpl salesService = new SalesServiceImpl();

  public static void run() {
    printTitle("영업");
    executeCommand(Sales.values());
  }

  public static void manageSales() {
    printTitle("영업 관리");
    executeCommand(SalesManagement.values());
  }

  public static void manageInsurance() {
    printTitle("보험 관리");
    System.out.println("상세 조회할 보험을 선택해주세요.");
    String[] args = {"insuranceCode", "name", "insuranceType", "coverDescription"};
    List<Insurance> insuranceList = salesService.getInsuranceList();
    printTable(insuranceList, args);

    Insurance insurance = insuranceList.get(input());
    printTitle("보험 상세 정보");
    printTable(insurance);
    System.out.println("보험 정보 조회를 완료하였습니다.");

    AuthCmd.initialize();
  }

  public static void manageCustomer() {
    printTitle("고객 관리");
    executeCommand(CustomerManagement.values());
  }

  public static void searchCustomer() {
    printTitle("고객 조회");
    System.out.println("상세 조회할 고객을 선택해주세요.");
    String[] args = {"name", "birth", "sex"};
    List<Customer> customerList = salesService.getCustomerList();
    printTable(customerList, args);

    Customer customer = customerList.get(input());
    printTitle("고객 정보 상세 조회");
    printTable(customer);
    System.out.println("고객 정보 조회를 완료하였습니다.");

    AuthCmd.initialize();
  }

  public static void signUpCustomer() {
    printTitle("신규 고객");
    System.out.println("신규 고객 정보를 입력해주세요.");
    Customer customer = Customer.builder().accountNumber(parser.getAccountNumber())
        .address(parser.getAddress()).birth(parser.getBirth()).job(parser.getJob())
        .name(parser.getName()).phoneNumber(parser.getPhoneNumber()).gender(parser.getGender())
        .build();

    salesService.createCustomer(customer);
    System.out.println("신규 고객 가입이 완료되었습니다.");

    AuthCmd.initialize();
  }

  public static void manageOrganization() {
    printTitle("조직 관리");
    System.out.println("상세 정보를 조회할 사원을 선택해주세요.");
    List<User> userList = salesService.getEmployeeList();
    printTable(userList, "id", "name");

    User user = userList.get(input());
    String[] args = {"id", "name", "email", "userType"};
    printTitle("사원 인적 정보");
    printTable(user, args);
    System.out.println("사원 정보 조회를 완료하였습니다.");

    AuthCmd.initialize();
  }

  public static void manageContract() {
    printTitle("계약 관리");
    executeCommand(ContractManagement.values());
  }

  public static void searchAllContract() {
    printTitle("모든 계약 조회");
    System.out.println("상세 정보를 조회할 계약을 선택해주세요.");
    String[] args = {"applicationDate", "customer", "insurance"};
    List<Contract> contractList = salesService.getContractList();
    printTable(contractList, args);

    Contract contract = contractList.get(input());
    printTitle("계약 상세 정보");
    printTable(contract);
    System.out.println("계약 정보 조회를 완료하였습니다.");

    AuthCmd.initialize();
  }

  public static void searchUWCompletedContracts() {
    printTitle("인수심사가 완료된 계약 조회");
    System.out.println("상세 정보를 조회할 계약을 선택해주세요.");
    String[] args = {"applicationDate", "customer", "insurance"};
    List<Contract> waitingContractList = salesService.getUWCompletedContracts();
    printTable(waitingContractList, args);

    Contract selectedContract = waitingContractList.get(input());
    printTable(selectedContract);
    proceedContract(selectedContract);
    System.out.println("미체결 정보 조회를 완료하였습니다.");

    AuthCmd.initialize();
  }

  public static void proceedContract(Contract contract) {

    printTitle("계약 진행");
    int selectedMenu = selectCommand(ContractProgress.values());
    Arrays.stream(ContractProgress.values()).forEach(menu -> {
      if (selectedMenu == menu.ordinal()) {
        menu.execute(contract);
      }
    });
  }

  public static void concludeContract(Contract contract) {
    printTitle("계약 체결");
    System.out.println("계약을 체결하시겠습니까?");
    if (selectYesOrNo()) {
      salesService.makeContractSigned(contract.getId());
      System.out.println("계약 체결이 완료되었습니다.");
      AuthCmd.initialize();
    } else {
      System.out.println("계약 체결을 취소합니다.");
      proceedContract(contract);
    }
  }

  public static void rejectContract(Contract contract) {
    printTitle("계약 거절");
    System.out.println("계약을 거절하시겠습니까?");
    if (selectYesOrNo()) {
      salesService.removeContract(contract.getId());
      System.out.println("계약 거절이 완료되었습니다.");
      AuthCmd.initialize();
    } else {
      System.out.println("계약 거절을 취소합니다.");
      proceedContract(contract);
    }
  }

  public static void makeContract() {
    printTitle("계약 생성");

    System.out.println("계약할 고객을 선택해주세요");
    List<Customer> customerList = salesService.getCustomerList();
    printTable(customerList);
    Customer customer = customerList.get(input());

    System.out.println("계약할 보험을 선택해주세요");
    List<Insurance> insuranceList = salesService.getInsuranceList();
    printTable(insuranceList);
    Insurance insurance = insuranceList.get(input());

    salesService.createContract(insurance, customer);
    System.out.println("계약 생성이 완료되었습니다.");

    AuthCmd.initialize();
  }

  public static void managePayment() {
    printTitle("납입금 관리");
    System.out.println("납입 리스트를 가져옵니다.");
    List<Transaction> transactionHistory = salesService.getTransactionHistory();
    printTable(transactionHistory);
  }
}
