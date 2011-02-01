package biz.evolix.service;

import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.dao.SmileUsersDetailDAO;

public class FindCodeIdServiceImp implements FindCodeIdService{
	@Autowired
	private SmileUsersDetailDAO smileUsersDetailDAO;
	@Override
	public int find(String codeId) {		
		return smileUsersDetailDAO.findCode(codeId);
	}
}
