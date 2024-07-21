package com.hotdealwork.hotdealwork.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SiteUser> _siteUser = userRepository.findByUsername(username);
        if (_siteUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        SiteUser siteUser = _siteUser.get();
        return new org.springframework.security.core.userdetails.User(
                siteUser.getUsername(),
                siteUser.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(siteUser.getRole().getValue()))
        );
    }
}