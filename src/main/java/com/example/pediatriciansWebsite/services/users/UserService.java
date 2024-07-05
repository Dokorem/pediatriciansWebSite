package com.example.pediatriciansWebsite.services.users;

import com.example.pediatriciansWebsite.models.UserModel;
import com.example.pediatriciansWebsite.repositories.UserRepository;
import com.example.pediatriciansWebsite.services.users.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserModel> user = Optional.ofNullable(repository.findByEmail(email));
        return user.map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(email + " not found"));
    }

    public boolean createUser(UserModel user) {
        String email = user.getEmail();
        if(repository.findByEmail(email) != null) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);

        return true;
    }

    public UserModel findUserByPrincipal(Principal principal) {
        if (principal == null) {
            return null;
        }
        return repository.findByEmail(principal.getName());
    }


}
