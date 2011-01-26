package biz.evolix.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import biz.evolix.customconst.ConstType;
import biz.evolix.gen.Generate;
import biz.evolix.model.NodeDescription;
import biz.evolix.model.NodePK;

public class Utils {
	public static void updateNodeDept(long nxt, NodeDescription dept,
			boolean test) {
		if (test) {
			while (nxt > dept.getUpper()) {
				dept.setHigh(dept.getHigh() + 1);
				dept.setLower(Generate.left(dept.getLower()));
				dept.setUpper(Generate.right(dept.getUpper()));
				dept.setNextId(dept.getLower());
				dept.setCount(0L);
			}
		}
	}
	public static void resetNodeDept(NodeDescription dept,boolean test){
		if(test){
			dept.setHigh(dept.getHigh() + 1);
			dept.setLower(new Long(2));
			dept.setUpper(new Long(3));
			dept.setNextId(dept.getLower());
			dept.setCount(0L);
		}
	}

	public static long buttomleft(long x, int high) {
		for (int i = 0; i < high; i++)
			x = Generate.left(x);
		return x;
	}

	public static long buttomright(long x, int high) {
		for (int i = 0; i < high; i++)
			x = Generate.right(x);
		return x;
	}

	public static List<String> hashCodes(String treeId,int baseLevel,long pos) {
		int height = baseLevel % ConstType.MAX_LEVEL;
		height = (height == 0)?0:ConstType.MAX_LEVEL-height;		
		long lpos = Utils.buttomleft(pos, height), rpos = Utils
				.buttomright(pos, height);		
		List<String>hashs = new ArrayList<String>();
		for (long i = lpos; i <= rpos; i++) 
			hashs.add(hashs.size(),NodePK.hashNode1(treeId+i));		
		return hashs;
	}
	public static boolean inRange(long x){
		return Generate.bottom(x);
	}
	private static Logger log = Logger.getLogger(Utils.class);
}
