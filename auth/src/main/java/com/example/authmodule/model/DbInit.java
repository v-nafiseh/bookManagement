//package com.example.authmodule.model;
//
//
//import com.example.authmodule.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class DbInit implements CommandLineRunner {
//    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//
//    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) {
//        // Delete all
//        this.userRepository.deleteAll();
//
//        // Crete users
//        Users nafiseh = new Users("nafiseh",passwordEncoder.encode("nafiseh123"),"USER, ADMIN");
//        Users admin = new Users("admin",passwordEncoder.encode("admin123"),"ADMIN");
//
//        List<Users> users = Arrays.asList(nafiseh,admin);
//
//        // Save to db
//        this.userRepository.saveAll(users);
//    }
//}
