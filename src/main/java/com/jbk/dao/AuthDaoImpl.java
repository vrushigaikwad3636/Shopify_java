package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.User;

@Repository
public class AuthDaoImpl implements AuthDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public int loginProcess(String username, String passowrd) {
		Session session = null;
		int status=0;
		try {
			session = factory.openSession();
			
			
			
		User user=	session.get(User.class, username);
		
		if(user!=null) {
			
			if(user.getPassword().equals(passowrd)) {
				status= 1; // success
			}
			else {
				status= 2; // invalid password
			}
		}else {
			status= 3; // invalid username
		}

		} catch (Exception e) {
			e.printStackTrace();
			status=4;   //something went wrong
		} finally {

		}

		return status;
	}

}
