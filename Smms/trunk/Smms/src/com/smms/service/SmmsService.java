package com.smms.service;

import java.util.List;

import com.smms.model.Account;

public interface SmmsService {
	public boolean authentication(String user,String passwd);
	public List<Account> getTeam(String id);
}
