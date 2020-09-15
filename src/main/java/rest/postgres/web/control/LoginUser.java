package rest.postgres.web.control;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class LoginUser implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		if (user == null) {
			throw new UsernameNotFoundException("ユーザーがNullです");
		}
		// DBから取り出しではなくユーザーおよびパスワードは固定。
		String password;
		switch (user) {
		case "user":
			password = DigestUtils.md5DigestAsHex((user + ":" + "Original Realm" + ":" + "passuser").getBytes());
			break;
		default :
			throw new UsernameNotFoundException("パスワードが一致しません");
		}
		
		return new User(user, password, Collections.emptySet());
	}
}