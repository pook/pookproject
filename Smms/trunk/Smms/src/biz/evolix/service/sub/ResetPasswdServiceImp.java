package biz.evolix.service.sub;

import java.util.ArrayList;
import java.util.List;

public class ResetPasswdServiceImp implements ResetPasswdService{

	@Override
	public void reset(String userIds) {
		String[] rowstr = userIds.split(",");List<Integer>rows = new ArrayList<Integer>();	
		for(String row : rowstr)rows.add(new Integer(row));		
		
	}

}
