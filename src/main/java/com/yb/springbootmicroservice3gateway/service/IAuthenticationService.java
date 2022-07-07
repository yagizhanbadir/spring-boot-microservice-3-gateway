package com.yb.springbootmicroservice3gateway.service;

import com.yb.springbootmicroservice3gateway.model.User;

public interface IAuthenticationService {
    String signInAndReturnJwt(User user);
}
