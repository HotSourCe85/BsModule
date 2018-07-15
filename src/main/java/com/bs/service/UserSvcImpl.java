package com.bs.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bs.mapper.UserMapper;
import com.bs.vo.ProcRtnVO;
import com.bs.vo.UserVO;

@Service
public class UserSvcImpl implements UserSvc {

	@Autowired
	UserMapper userMapper;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO user = userMapper.getUser(username);
		user.setAuthorities(getAuthorities(username));

		return user;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities(String username) {
		List<GrantedAuthority> authorities = userMapper.getAuthority(username);
		return authorities;
	}

	@Override
	public UserVO getUser(String username) {
		UserVO user = userMapper.getUser(username);
		user.setAuthorities(userMapper.getAuthority(username));

		return user;
	}

	@Override
	public UserVO insertUser(UserVO user) {
		String rawPassword = user.getPassword();
		String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
		user.setPassword(encodedPassword);
		int a = userMapper.insertUser(user);
		//userMapper.insertAuthority(user);

		return null;
	}

	@Override
	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}

}
