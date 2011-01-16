package biz.evolix.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import biz.evolix.model.Staff;
import biz.evolix.model.Users;
import biz.evolix.model.bean.UserStaff;
import biz.evolix.model.dao.StaffDAO;

public class StaffServiceImp implements StaffService {
	@Autowired
	private StaffDAO staffDAO;

	private List<UserStaff> staffs;

	@Override
	public int size() {
		long l = staffDAO.size();
		return (int) l;
	}

	@Override
	public List<UserStaff> staffs(int start, int max) {
		List<Users> users = staffDAO.findAllStaff(start, max);
		return staff(users);
	}

	private List<UserStaff> staff(List<Users> users) {
		staffs= new ArrayList<UserStaff>();
		int i = 0;
		for (Users u : users) {
			Staff staff = staffDAO.find(u.getUserId());
			staffs.add(new UserStaff(i++, u.getUserId(), u.getNode1()
					.getSmileId(), u.getDetail().getName(), u.getDate(), staff
					.getBrance()));
		}
		return staffs;
	}

	public void setStaffDAO(StaffDAO staffDAO) {
		this.staffDAO = staffDAO;
	}

	public StaffDAO getStaffDAO() {
		return staffDAO;
	}

	@Override
	public void editBrance(int idx, String brance) {		
		UserStaff staff = staffs.get(idx);	
		Staff s = staffDAO.find(staff.getUserId());
		if (s != null){
			s.setBrance(brance);
			staffDAO.merg(s);
		}
			
	}
	
	public List<UserStaff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<UserStaff> staffs) {
		this.staffs = staffs;
	}

	private static Logger log = Logger.getLogger(StaffServiceImp.class);

}
