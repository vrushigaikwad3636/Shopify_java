package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jbk.model.LoginRequest;
import com.jbk.service.AuthService;

@Controller
public class AuthController {

	@Autowired
	private AuthService authService;

	// how to map any reuest
//	@PostMapping("/login-user") // how to handle request data using @RequestParam
//	public String loginProcess(@RequestParam String username, @RequestParam String password) {
//		System.out.println(username);
//		System.out.println(password);
//
//		return null;
//
//	}

	@PostMapping("/login-user") // how to handle request data @ModelAttribute
	public String loginProcess(@ModelAttribute LoginRequest loginData, Model model) {

		int status = authService.loginProcess(loginData.getUsername(), loginData.getPassword());

		switch (status) {
		case 1: {

			return "home";

		}
		case 2: {// invalid password
			model.addAttribute("msg", "invalid password");
			return "login";
		}
		case 3: {// invalid username
			model.addAttribute("msg", "invalid username");
			return "login";
		}
		case 4: { // something went wrong
			model.addAttribute("msg", "something went wrong");
			return "login";
		}
		default:
			return "login";
		}

	}

}
