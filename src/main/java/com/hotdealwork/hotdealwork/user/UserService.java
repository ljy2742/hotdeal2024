package com.hotdealwork.hotdealwork.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean deleteUser(String username, String password) {
        Optional<SiteUser> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            SiteUser user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                userRepository.deleteByUsername(username);
                return true;
            }
        }

        return false;
    }
}