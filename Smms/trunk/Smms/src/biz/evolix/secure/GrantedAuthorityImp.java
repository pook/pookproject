package biz.evolix.secure;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImp implements GrantedAuthority {

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 13;
		result = prime * result
				+ ((authority == null) ? 0 : authority.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		GrantedAuthorityImp other = (GrantedAuthorityImp) obj;
		if (authority == null ||other.authority == null) 			
				return false;
		return authority.equals(other.getAuthority());
	}

}
