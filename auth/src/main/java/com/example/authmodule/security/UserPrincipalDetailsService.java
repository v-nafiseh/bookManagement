//package com.example.authmodule.security;
//
//import com.example.authmodule.model.Users;
//import com.example.authmodule.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserPrincipalDetailsService implements UserDetailsService {
//
//    private UserRepository userRepository;
//
//    public UserPrincipalDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = this.userRepository.findByUsername(username);
//        UserPrincipal userPrincipal = new UserPrincipal(user);
//
//        return userPrincipal;
//    }
//}
