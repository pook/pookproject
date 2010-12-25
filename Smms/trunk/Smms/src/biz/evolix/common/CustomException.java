package biz.evolix.common;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -3607737583698731704L;

	public CustomException(String msg) {
		super(msg);
	}
}
