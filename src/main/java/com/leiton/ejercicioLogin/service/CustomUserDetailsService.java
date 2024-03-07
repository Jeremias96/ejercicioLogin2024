package com.leiton.ejercicioLogin.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.leiton.ejercicioLogin.dao.UserRepository;
import com.leiton.ejercicioLogin.entity.UserEntity;

public class CustomUserDetailsService implements UserDetailsService{

    //get user from the database, via Hibernate
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
    //CUSTOM USER HERE vvv
            UserEntity user = userRepository.findByEmail(email).orElseThrow();
            List<GrantedAuthority> authorities =
                                        buildUserAuthority(user.getUserRole());
    //if you're implementing UserDetails you wouldn't need to call this method and instead return the User as it is
            //return buildUserForAuthentication(user, authorities);
    return user;

    }

    // Converts user to spring.springframework.security.core.userdetails.User
    private UserEntity buildUserForAuthentication(user,
        List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
            user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // add user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

}
