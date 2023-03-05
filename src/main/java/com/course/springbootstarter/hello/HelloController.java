package com.course.springbootstarter.hello;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHi() {
		Collection auth = SecurityContextHolder. getContext().getAuthentication().getAuthorities();
		Object name = SecurityContextHolder. getContext().getAuthentication().getPrincipal();
		return "Hi! from DB program! "+name+" "+auth ;
	}

}
