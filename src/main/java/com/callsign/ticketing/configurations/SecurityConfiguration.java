package com.callsign.ticketing.configurations;

import com.callsign.ticketing.data.repositories.UserInfoRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  private final DataSource dataSource;
  private final UserInfoRepository userInfoRepository;

  public SecurityConfiguration(DataSource dataSource, UserInfoRepository userInfoRepository) {
    this.dataSource = dataSource;
    this.userInfoRepository = userInfoRepository;
  }

  public void authenticationConfiguration(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
        .dataSource(dataSource)
        .usersByUsernameQuery("select user_id, user_name, password from user_info where user_name=?");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
  }

}
