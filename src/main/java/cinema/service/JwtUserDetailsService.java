package cinema.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("administrator".equals(username)) {
			return new User(
					"administrator",
					passwordEncoder.encode("bangtan"),
//					"$2y$10$iEaxi4Ixzu1WueIxLJygD.jsIjSTfXApSx3qjJL.Ae5ZlWonU5DG",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with this username");
		}				
	}

}
