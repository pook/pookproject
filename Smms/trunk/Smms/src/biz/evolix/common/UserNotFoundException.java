package biz.evolix.common;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -20984674790249452L;
	public UserNotFoundException(String member){
		super("Member Not Found !"+member);
	}
}
