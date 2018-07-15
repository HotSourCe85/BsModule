package com.bs.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bs.vo.ProcRtnVO;
import com.bs.vo.UserVO;

public interface UserSvc extends UserDetailsService {
	Collection<GrantedAuthority> getAuthorities(String username);
	public UserVO getUser(String username);
	public UserVO insertUser(UserVO user); 
	public PasswordEncoder passwordEncoder();

}
