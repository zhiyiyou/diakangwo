package com.diankangwo.controller;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.diankangwo.dao.UserDAO;

@Controller
public class TestController {
	
	@Autowired
	private UserDAO userDao;
	
	@Resource
	private ReflectionSaltSource saltSource;
	
	@Resource
	private ShaPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/test/123", method = RequestMethod.GET)
	public String test() {
		return "index";
	}
	
	@RequestMapping(value = "/test/234", method = RequestMethod.GET)
	public String test2() {
		return "index";
	}
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String login() {
		return "login";
	}
}
