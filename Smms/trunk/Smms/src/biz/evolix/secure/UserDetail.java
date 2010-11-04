package biz.evolix.secure;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetail implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String userid)
			throws UsernameNotFoundException {
		try{
			SmileUser d = new SmileUser();
		    d.loadUser(userid);
			return d;
		}catch (Exception e) {
			System.err.println(e);
			throw new UsernameNotFoundException(e+": username");
		}
				
	}
	
	

}
