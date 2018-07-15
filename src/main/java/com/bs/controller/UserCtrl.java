package com.bs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.logging.log4j.util.Strings;
import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bs.service.UserSvc;
import com.bs.vo.ProcRtnVO;
import com.bs.vo.UserVO;

@Controller
public class UserCtrl {
	@Autowired
	private UserSvc userSvc;
	
	
    @RequestMapping(value="/login")
    public String login(Model model, HttpServletRequest req){
        return "logIn";
    }
    
    @RequestMapping(value="/signUp")
    public String signUp(Model model, HttpServletRequest req){
        return "signUp";
    }
	
    @RequestMapping(value="/signUpUser")
	//public String insertUser(Model model, @RequestBody Map<String, Object> reqMap) {
    public String insertUser(Model model, HttpServletRequest req, RedirectAttributes redirectAttributes) {
    	String email = String.valueOf(req.getParameter("email"));
		String username = String.valueOf(req.getParameter("username"));
		String name = String.valueOf(req.getParameter("name"));
		String password = String.valueOf(req.getParameter("password"));
		
		boolean validEmail = EmailValidator.getInstance().isValid(email);
		boolean validUserName = Strings.isEmpty(username);
		boolean validName = Strings.isEmpty(name);
		boolean validpassword = Strings.isEmpty(password);
		String errMsg = "";
		if(!validEmail) {
			errMsg = "Email Value is Wrong.";
		}else if(validUserName) {
			errMsg = "ID Value is Wrong.";
		}else if(validName) {
			errMsg = "Name Value is Wrong.";
		}else if(validpassword) {
			errMsg = "Password Value is Wrong.";
		}
		
		if(Strings.isNotEmpty(errMsg)) {
			redirectAttributes.addFlashAttribute("email", email);
			redirectAttributes.addFlashAttribute("username", username);
			redirectAttributes.addFlashAttribute("name", name);
			redirectAttributes.addFlashAttribute("InputError", errMsg);
			return "redirect:/signUp";
		}
		
		UserVO user = new UserVO();
		user.setEmail(email);
		user.setUsername(username);
		user.setName(name);
		user.setPassword(password);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true); 
		user.setEnabled(true); 
		user.setAuthorities(AuthorityUtils.createAuthorityList("USER"));
    	
    	userSvc.insertUser(user);
    	
    	return "login";
	}
    
    
	@RequestMapping("/insert")
	public String insert() {
		UserVO user = new UserVO();
		
		user.setEmail("hotsource85@gmail.com");
		user.setUsername("test");
		user.setName("test");
		user.setPassword("12345");
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true); 
		user.setEnabled(true); 
		user.setAuthorities(AuthorityUtils.createAuthorityList("USER"));
		
		userSvc.insertUser(user);
		
		return "login";
	}
	
}
