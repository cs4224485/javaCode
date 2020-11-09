package com.harry.security.auth2.uaa.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //安全拦截机制（最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()//  http.authorizeRequests() 方法有多个子节点，每个macher按照他们的声明顺序执行。
                .antMatchers("/r/r1").hasAuthority("p1")// 指定"/r/r1"URL，拥有p1权限能够访问
                .antMatchers("/r/r2").hasAuthority("p2")// 指定"/r/r2"URL，拥有p2权限能够访问
                .antMatchers("/r/**").authenticated()//所有/r/**的请求必须认证通过
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated()//除了/r/**，其它的请求可以访问
                .and()
                .formLogin();//允许表单登录
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
