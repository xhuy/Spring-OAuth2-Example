package xyz.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.test.model.UserModel;
import xyz.test.pojo.User;

@Service
public class UserLoginService implements UserDetailsService {

    @Transactional
    public UserDetails loadUserByUsername(String username)
	    throws UsernameNotFoundException {
	User user = new User();
	user = findByUsername(username);

	if (user == null) {
	    System.out.println("User not found");
	    throw new UsernameNotFoundException("Username not found");
	}

	List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

	authorities.add(new SimpleGrantedAuthority(user.getRole()
		.getDescription()));

	return new org.springframework.security.core.userdetails.User(
		user.getUsername(), user.getPassword(), user.getEnable(), true,
		true, true, authorities);
    }

    public User findByUsername(String usuario) {
	return UserModel.findByUsername(usuario);
    }

}
