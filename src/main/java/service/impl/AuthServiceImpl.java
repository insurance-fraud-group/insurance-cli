package service.impl;

import domain.User;
import repository.UserRepository;
import service.AuthService;

public class AuthServiceImpl implements AuthService {

  private final UserRepository userRepository;

  public AuthServiceImpl() {
    userRepository = new UserRepository();
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
