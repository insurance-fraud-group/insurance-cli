package service.impl;

import domain.User;
import repository.EmployeeRepository;
import service.AuthService;

public class AuthServiceImpl implements AuthService {

  private final EmployeeRepository userRepository;

  public AuthServiceImpl() {
    userRepository = new EmployeeRepository();
  }

  @Override
  public User signUp(User request) {
    User user = User.builder().userType(request.getUserType())
        .email(request.getEmail()).password(request.getPassword()).name(request.getName()).build();
    userRepository.save(user);
    return user;
  }

  @Override
  public User signIn(User request) {
    User user = userRepository.findBy("email", request.getEmail());
    if (user == null) {
      return null;
    }
    return request.getPassword().equals(user.getPassword()) ? user : null;
  }
}
