package biz.evolix.secure;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetail implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String userid)
			throws UsernameNotFoundException {
		try{
			SmileUser d = new SmileUser(userid);
			System.err.println("  00");
		    d.loadUser();
			return d;
		}catch (Exception e) {
			System.err.println(e+"  1");
			throw new UsernameNotFoundException(e+": username");
		}				
	}
}
