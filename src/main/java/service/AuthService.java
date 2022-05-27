package service;

import dto.AuthDto;

public interface AuthService {

  AuthDto.SignupResponse signup(AuthDto.SignupRequest request);

  AuthDto.SigninResponse signin(AuthDto.SigninRequest request);
}
