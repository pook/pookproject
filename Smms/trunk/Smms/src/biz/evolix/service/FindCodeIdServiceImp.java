package biz.evolix.service;

import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.dao.SmileUsersDetailDAO;

public class FindCodeIdServiceImp implements FindCodeIdService{
	@Autowired
	private SmileUsersDetailDAO smileUsersDetailDAO;
	@Override
	public boolean find(String codeId) {
		// TODO Auto-generated method stub
		return false;
	}

}
