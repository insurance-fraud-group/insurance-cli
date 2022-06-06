package service.impl;

import domain.AcceptancePolicy;
import domain.Contract;
import domain.Insurance;
import domain.InsuranceCompany;
import domain.Transaction;
import domain.Underwriting;
import domain.User;
import domain.enums.TransactionType;
import java.util.List;
import java.util.stream.Collectors;
import repository.AcceptancePolicyRepository;
import repository.EmployeeRepository;
import repository.InsuranceCompanyRepository;
import repository.InsuranceRepository;
import repository.TransactionRepository;
import repository.UnderwritingRepository;
import service.UnderwritingService;

public class UnderwritingServiceImpl implements UnderwritingService {

  private final UnderwritingRepository underwritingRepository;
  private final AcceptancePolicyRepository acceptancePolicyRepository;
  private final EmployeeRepository userRepository;
  private final InsuranceCompanyRepository insuranceCompanyRepository;
  private final InsuranceRepository insuranceRepository;
  private final TransactionRepository transactionRepository;

  public UnderwritingServiceImpl() {
    underwritingRepository = new UnderwritingRepository();
    userRepository = new EmployeeRepository();
    acceptancePolicyRepository = new AcceptancePolicyRepository();
    insuranceCompanyRepository = new InsuranceCompanyRepository();
    insuranceRepository = new InsuranceRepository();
    transactionRepository = new TransactionRepository();
  }

  public User getEmployeeName(User user) {
    return userRepository.findBy("name", user);
  }

  @Override
  public List<AcceptancePolicy> searchAcceptancePolicy() {
    return acceptancePolicyRepository.findAll();
  }

  @Override
  public void createAcceptancePolicy(AcceptancePolicy acceptancePolicy) {
    acceptancePolicyRepository.save(acceptancePolicy);
  }

  @Override
  public List<Underwriting> searchUnderwriting() {
    return underwritingRepository.findAll();
  }

  @Override
  public List<Underwriting> searchUnsignedUnderwriting() {
    return underwritingRepository.findAllBy("signed", false);
  }

  @Override
  public boolean underwrite(Underwriting underwriting) {
    boolean signed = checkSigned(underwriting);
    underwriting.setSigned(signed);
    underwritingRepository.update(underwriting);
    return signed;
  }

  private boolean checkSigned(Underwriting underwriting) {
    return underwriting.getPhysicalFactorScore() + underwriting.getMoralFactorScore()
        + underwriting.getFinancialFactorScore() + underwriting.getEnvironmentalFactorScore() > 10;
  }

  @Override
  public List<InsuranceCompany> searchInsuranceCompany() {
    return insuranceCompanyRepository.findAll();
  }

  @Override
  public void makeUnderwritingSigned(Underwriting underwriting) {
    underwriting.setSigned(true);
    underwritingRepository.update(underwriting);
  }

  @Override
  public List<Insurance> getInsuranceList() {
    return insuranceRepository.findAll();
  }

  @Override
  public float calculateLossRate(Contract contract) {
    List<Transaction> transactionList = transactionRepository.findAll().stream()
        .filter(transaction -> transaction.getContract().getId() == contract.getId()).collect(
            Collectors.toList());

    int deposit = transactionList.stream()
        .filter(transaction -> transaction.getType() == TransactionType.DEPOSIT)
        .mapToInt(transaction -> transaction.getAmount()).sum();

    int withdraw = transactionList.stream()
        .filter(transaction -> transaction.getType() == TransactionType.WITHDRAW)
        .mapToInt(transaction -> transaction.getAmount()).sum();

    return (deposit == 0) ? 0 : withdraw / deposit * 100;
  }

}
