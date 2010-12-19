package biz.evolix.action.global;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class FileLastMod implements FilenameFilter {

	private static final String PREFIX = "smile_com_";

	@Override
	public boolean accept(File dir, String name) {			
		StringBuilder sb = new StringBuilder();
		sb.append(PREFIX)
		.append(dateString())
		.append(this.month);		
		return name.startsWith(sb.toString()) && name.endsWith(".cvs");
	}
	private static String dateString() {
		final String dateFormat = "yyyy:";
		SimpleDateFormat format = new SimpleDateFormat(dateFormat,
				Locale.getDefault());
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		return format.format(new Date());
	}
	private String month;

	public FileLastMod(String month) {
		super();
		this.month = month;
	}
	
}
