package com.example.authmodule.service;

import com.example.authmodule.model.Users;
import com.example.authmodule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.LongFunction;

@Service
public class AdminService {

    private final UserRepository userRepository;

    @Autowired
    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(Users users){
        userRepository.save(users);
    }

    public void deleteUser(Long id){
        boolean exists = userRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("user with this id does not exist!!");
        }
        userRepository.deleteById(id);
    }

//    @Transactional
//    public void updateUser(Long id, String username){
////        Users user = userRepository.findByUsername(username);
//        Users user = userRepository.findUSerById(id);
//        user.setUsername(username);
//
//    }

    @Transactional
    public void update(Long id, Users users){
        Users user = userRepository.findUSerById(id);
        user.setUsername(users.getUsername());

    }

    public Users getUser(Long id){
        return userRepository.findUSerById(id);
    }


    public List<Users> getUsers(){
        return userRepository.findAll();
    }


}
