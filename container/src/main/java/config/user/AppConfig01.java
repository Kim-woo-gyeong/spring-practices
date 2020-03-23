package config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.user.User;

public class AppConfig01 {
	
	@Bean
	public User user() {
		return new User();
	}
}
