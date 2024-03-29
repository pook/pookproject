package biz.evolix.secure;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetail implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String smileId)
			throws UsernameNotFoundException {
		try{
			SmileUser d = new SmileUser(smileId);			
		    d.loadUser();
			return d;
		}catch (Exception e) {
			throw new UsernameNotFoundException(e+": username");
		}				
	}
}
