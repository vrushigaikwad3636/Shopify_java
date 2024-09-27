package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.AuthDao;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthDao authDao;

	@Override
	public int loginProcess(String username, String passowrd) {

		int status = authDao.loginProcess(username, passowrd);
		return status;
	}

}
