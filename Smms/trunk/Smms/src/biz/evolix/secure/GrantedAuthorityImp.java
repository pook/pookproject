package biz.evolix.secure;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImp implements GrantedAuthority {

	/**
	 * 
	 */
	private String authority;
	
	private static final long serialVersionUID = -6341681948807334867L;

	@Override
	public String getAuthority() {
		
		return this.authority;
	}

	public GrantedAuthorityImp(String authority) {
		super();
		this.authority = authority;
	}
	
}
