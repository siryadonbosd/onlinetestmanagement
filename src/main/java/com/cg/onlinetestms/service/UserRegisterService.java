package com.cg.onlinetestms.service;

import com.cg.onlinetestms.dto.UserDetails;

public interface UserRegisterService {

	UserDetails findByName(UserDetails userDetails);

	UserDetails register(UserDetails uDetails);

}
