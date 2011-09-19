package biz.evolix.gen;

import java.security.NoSuchAlgorithmException;

public class Generate {
	public static final long AUTO = -2;
	private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final byte BASE = 2;
	private static final long MAX_ID = 0x5f5e0ff;
	private static final String DIGITS = "0123456789abcdef";
	public static final long MAX_NODE62 = 0x4000000000000000L;
	public static final long MAX_NODE63 = 0x7fffffffffffffffL;

	public synchronized static String smileId(long userId, int level,
			String provinceCode) {
		StringBuilder b = new StringBuilder();
		codeId(b, level);
		b.append(provinceCode);
		if (userId > MAX_ID)
			userId = -MAX_ID;
		stringId(b, userId);
		return b.toString();
	}

	public synchronized static int log2(final Long x) {
		double y = Math.log(x) / Math.log(BASE);
		return (int) Math.floor(y);
	}

	private synchronized static void codeId(StringBuilder sb, int level) {
		int i = level / ALPHA.length();
		int j = level % ALPHA.length();
		i = codeId2(sb, i);
		sb.append(ALPHA.charAt(i));
		sb.append(ALPHA.charAt(j));
	}

	private static int codeId2(StringBuilder sb, int i) {
		if (i > 25) {
			i = i / ALPHA.length();
			i = codeId2(sb, i - 1);
			sb.append(ALPHA.charAt(i));
		}
		return i;
	}

	private synchronized static void stringId(StringBuilder b, Long userId) {
		switch (userId.toString().length()) {
		case 1:
			b.append("0000000");
			break;
		case 2:
			b.append("000000");
			break;
		case 3:
			b.append("00000");
			break;
		case 4:
			b.append("0000");
			break;
		case 5:
			b.append("000");
			break;
		case 6:
			b.append("00");
			break;
		case 7:
			b.append("0");
			break;
		}
		b.append(userId);
	}

	public static long math2Pow(long x) {
		final long y = 1;
		return (long) y << x;
	}

	public static double xCommission(final int sv) {
		return (sv << 1) / 100;
	}

	public static String generateIdSHA(String word)
			throws NoSuchAlgorithmException {
		return hashAlgorilthm("SHA", word);
	}

	public static String generateHashAlgorilthm(String algorithm, String word)
			throws NoSuchAlgorithmException {
		return hashAlgorilthm(algorithm, word);
	}

	public static String hashAlgorilthm(String algorithm, String word)
			throws NoSuchAlgorithmException {
		try {
			return hexEncode(java.security.MessageDigest.getInstance(algorithm)
					.digest(word.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			throw new NoSuchAlgorithmException();
		}
	}

	private static String hexEncode(byte[] sha) {
		StringBuilder r = new StringBuilder();
		for (int idx = 0; idx < sha.length; ++idx) {
			byte b = sha[idx];
			r.append(DIGITS.charAt((b & 0xf0) >> 4));
			r.append(DIGITS.charAt(b & 0x0f));
		}
		return r.toString();
	}

	public static long next(final long id) {
		return id + 1;
	}

	public static long parent(long x) {
		return x >> 1;
	}

	public static long left(long x) {
		return x << 1;
	}

	public static long right(long x) {
		return (x << 1) + 1;
	}

	public static boolean isLeft(long id) {
		return id % 2 == 0;
	}

	public static boolean bottom(long id) {
		return id >= MAX_NODE62 && id <= MAX_NODE63;
	}
}
