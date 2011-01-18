package biz.evolix.action.global;

import java.io.File;
import java.io.FilenameFilter;

public class FileLastMod implements FilenameFilter {

	private static final String PREFIX = "smile_com_";

	@Override
	public boolean accept(File dir, String name) {			
		StringBuilder sb = new StringBuilder();
		sb.append(PREFIX)		
		.append(this.month);		
		return name.startsWith(sb.toString()) && name.endsWith(".cvs");
	}	
	private String month;

	public FileLastMod(String month) {
		super();
		this.month = month;
	}
	
}
