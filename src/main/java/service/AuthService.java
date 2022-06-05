package service;

import domain.User;

public interface AuthService {

  User signUp(User request);

  User signIn(User request);
}
