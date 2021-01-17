package com.bijay.expensetracker.services;

import com.bijay.expensetracker.domain.User;
import com.bijay.expensetracker.exceptions.EtAuthException;

public interface UserService {
	
	User validateUser(String email, String password) throws EtAuthException;
	
	User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;

}
