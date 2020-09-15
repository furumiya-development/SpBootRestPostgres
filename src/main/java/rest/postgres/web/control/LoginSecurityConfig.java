package rest.postgres.web.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private LoginUser loginuser;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/rest")
			.authorizeRequests()
				.antMatchers("/").permitAll() //ルートは全ユーザーがアクセス可能。
				.anyRequest().authenticated() //その他のURLは認証が必要
			.and()
				.addFilter(digestFilter(digestEntry()))
				.exceptionHandling().authenticationEntryPoint(digestEntry())
			.and()
			.csrf().disable()
			;
	}
	
	private DigestAuthenticationEntryPoint digestEntry() {
		var entry = new DigestAuthenticationEntryPoint();
		entry.setRealmName("Original Realm");
		entry.setKey("acegi");
		entry.setNonceValiditySeconds(60);
		return entry;
	}
	
	private DigestAuthenticationFilter digestFilter(DigestAuthenticationEntryPoint entry) {
		var filter = new DigestAuthenticationFilter();
		filter.setAuthenticationEntryPoint(entry);
		filter.setUserDetailsService(loginuser);
		filter.setPasswordAlreadyEncoded(true); //true=MD5、false=平文
		return filter;
	}
	
	@Autowired
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginuser);
	}
	
	@Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}