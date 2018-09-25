package com.wjspc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by 79445 on 2018/5/29.
 */
@Configuration
@EnableWebSecurity  //spring Security开启注解，同事继承WebSecurityConfigurerAdapter就完成了spring Security的配置
@PropertySource("classpath:security-default.properties")
@EnableGlobalMethodSecurity(prePostEnabled = true)//允许进入页面方法前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *
     */
    @Value("${login.matchers}")
    private String matchers1;

    /**
     * @return AuthenticationTokenFilter
     * @throws Exception Exception
     */
    /*@Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
        authenticationTokenFilter.setAuthenticationManager(authenticationManagerBean());
        return authenticationTokenFilter;
    }*/

    /**
     * 重写configure()方法配置相关的安全配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http
                .authorizeRequests()
                    .antMatchers( "/login").permitAll()  //制定那些不用认证就可以访问
                    .anyRequest().authenticated()
                    .and()
        .formLogin()
                    .loginPage("/login")    //认证通过后跳转到哪里
                    .permitAll()
                    .and()
                .logout()
                .permitAll();*/


       /* httpSecurity
                // 由于使用的是JWT，我们这里不需要csrf
                .csrf().disable()

                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests()
                //.antMatchers(HttpMethod.OPTIONS, "*//**").permitAll()

                // 允许对于网站静态资源的无授权访问
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "*//*.html",
                        "/favicon.ico"
                ).permitAll()
                // 对于获取token的rest api要允许匿名访问
                .antMatchers("/auth*//**").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated();

        // 禁用缓存
        httpSecurity.headers().cacheControl();*/



        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry
                expressionInterceptUrlRegistry = http
                                                    .csrf().disable()   // 默认情况下，当使用WebSecurityConfigurerAdapter时的默认构造方法时CSRF是激活的， 直接关闭防跨域攻击功能（防止post、put等请求被拦截）
                                                    .authorizeRequests();

        String[] matcherList = matchers1.split(",");
        for (String mather : matcherList) {
            expressionInterceptUrlRegistry = expressionInterceptUrlRegistry.antMatchers(mather).permitAll();
        }
        expressionInterceptUrlRegistry
                .anyRequest()
                .authenticated();
                /*.and()
            .formLogin()
                .loginPage("/login")    //认证通过后跳转到哪里
                .permitAll()
                .and()
                .logout()
                .permitAll();*/

        // Custom JWT based authentication
        //http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {   //在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER

        /*
            auth
                    .inMemoryAuthentication()   //此方法用来添加在内存中的用户，并指定角色
                        .passwordEncoder(new BCryptPasswordEncoder())   //登陆时用BCrypt加密方式对用户密码进行处理
                        .withUser("user")
                        .password(new BCryptPasswordEncoder().encode("123456")) //对内存中的密码进行Bcrypt编码加密
                        //如果你用的是在数据库中存储用户名和密码，那么一般是要在用户注册时就使用BCrypt编码将用户密码加密处理后存储在数据库中
                        .roles("USER");
        */

        /*auth
                .jdbcAuthentication()
                .usersByUsernameQuery("sql")    //指定查询用户SQL
                .authoritiesByUsernameQuery("sql");   //指定查询权限SQL*/


        //auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query).authoritiesByUsernameQuery(query);

        //注入userDetailsService，需要实现userDetailsService接口
        //auth.userDetailsService(userDetailsService);

    }


}
