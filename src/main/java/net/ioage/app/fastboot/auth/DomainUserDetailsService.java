package net.ioage.app.fastboot.auth;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.ioage.app.fastboot.auth.entity.User;
import net.ioage.app.fastboot.auth.mapper.UserMapper;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Authenticate a user from the database.
 */
//@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final UserMapper userMapper;

    public DomainUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);
        return null;
//
//        if (new EmailValidator().isValid(login, null)) {
//            QueryWrapper<User> userWrapper = new QueryWrapper<>();
//            userWrapper.eq("email",login);
//            return userMapper.selectList(userWrapper)
//                .map(user -> createSpringSecurityUser(login, user))
//                .orElseThrow(() -> new UsernameNotFoundException("User with email " + login + " was not found in the database"));
//        }
//
//        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
//        return userRepository.findOneWithAuthoritiesByLogin(lowercaseLogin)
//            .map(user -> createSpringSecurityUser(lowercaseLogin, user))
//            .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));

    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
        if (!user.getActivated()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
        }
        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
            .map(authority -> new SimpleGrantedAuthority(authority.getName()))
            .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
            user.getPassword(),
            grantedAuthorities);
    }
}
