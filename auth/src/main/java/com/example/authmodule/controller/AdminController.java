package com.example.authmodule.controller;

import com.example.authmodule.model.Users;
import com.example.authmodule.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

//    @PreAuthorize("hasRole('ADMIN')") first
//    @GetMapping("/all")
//    public List<Users> allUsers(){
//        return adminService.getUsers();
//    }

    @GetMapping("/admin")
    public ModelAndView allUsers(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admin_page");
        modelAndView.addObject("userList", adminService.getUsers());
        return modelAndView;
    }

//true
//    @PostMapping("/add")
//    public void addUser(@RequestBody Users users){
//        adminService.addUser(users);
//    }

    @GetMapping(value = "/addUser")
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/userAddPage");
        return modelAndView;
    }

    @PostMapping(value = "/addUser")
    public ModelAndView addUser(@ModelAttribute("user") Users user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        adminService.addUser(user);
        return modelAndView;
    }
        //true
//    @DeleteMapping(path = "{id}")
//    public void deleteUser(@PathVariable("id") Long id){
//        adminService.deleteUser(id);
//    }

//        @RequestMapping("deleteUser/{id}")
//        public ModelAndView delete(@PathVariable("id") Long id){
//            ModelAndView modelAndView = new ModelAndView();
//            adminService.deleteUser(id);
//            modelAndView.setViewName("redirect:/admin");
//            return modelAndView;
//        }

        @RequestMapping("deleteUser/{id}")
        public ModelAndView delete(@PathVariable("id") Long id){
            ModelAndView modelAndView = new ModelAndView();
            adminService.deleteUser(id);
            modelAndView.setViewName("redirect:/admin");
            return modelAndView;
        }


//    @PutMapping("{id}")
//    public void updateUser(@PathVariable("id") Long id,
//                           @RequestParam(required = false) String username){
//        adminService.updateUser(id, username);
//    }

//    @PutMapping("admin/update/{id}")
//    public ModelAndView update(@PathVariable("id") Long id,
//                               @RequestParam(required = false) String username){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("admin/edit_user");
//
//
//    }

        @GetMapping("/updateUser/{id}")
        public ModelAndView update(@PathVariable("id") Long id){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/admin/edit_user");
            Users user = adminService.getUser(id);
            modelAndView.addObject("user", user);
            return modelAndView;

        }

        @GetMapping("/updateUser")
        public ModelAndView update(@ModelAttribute("user") Users user){

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/admin");
            Long id = user.getId();
            adminService.update(id, user);
            return modelAndView;


        }


    }


