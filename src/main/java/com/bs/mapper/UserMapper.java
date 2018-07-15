package com.bs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.bs.vo.UserVO;

@Mapper
public interface UserMapper {
	public UserVO getUser(String username); 
	public List<GrantedAuthority> getAuthority(String username);
	public int insertUser(UserVO user);
	public void insertAuthority(UserVO user);
	
}
