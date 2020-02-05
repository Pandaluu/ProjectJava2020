package cinema.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtUserDetailsService {

	UserDetails loadUserByUsername(String username);

}
