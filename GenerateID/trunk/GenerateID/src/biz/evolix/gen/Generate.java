package biz.evolix.gen;

public class Generate {
	public static final long AUTO=-2;
	private static final char[] ALPHA = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z' };
	private static final byte BASE = 2;

	public synchronized static String getId(Long x,String provinceCode) {
		int count=0,y=log2(x);		
		while(y>=ALPHA.length){
			++count;			
			y-=ALPHA.length;
		}
		StringBuilder b = new StringBuilder();
		b.append(ALPHA[count]);
		b.append(ALPHA[y]);
		b.append(provinceCode);
		stringId(b,x);
		return b.toString();
	}

	public synchronized static int log2(final Long x) {
		double y = Math.log(x) / Math.log(BASE);
		return (int) Math.floor(y);
	}
	private synchronized static void stringId(StringBuilder b,Long x){
		String id=""+x;
		switch(id.length()){
		case 1:
			b.append("0000000");break;
		case 2:
			b.append("000000");break;
		case 3:
			b.append("00000");break;
		case 4:
			b.append("0000");break;
		case 5:
			b.append("000");break;
		case 6:
			b.append("00");break;
		case 7:
			b.append("0");break;
		case 8:
			break;
			default:
				throw new NumberFormatException("Out of length support");
		}
		b.append(x);		
	}
	public static Long getParentId(Long x){
		return x>>1;
	}
	public static Long getLeftChildId(Long x){
		return x<<1;
	}
	public static Long getRightChildId(Long x){
		return 1+(x<<1);
	}
	public static long math2Pow(int x){
		final long y=1;
		return (long) y<<x;
	}
}
