package com.learnAloneJavaAvanced.CRUD.Alone.controllers;

import com.learnAloneJavaAvanced.CRUD.Alone.models.LoginModels;
import com.learnAloneJavaAvanced.CRUD.Alone.service.LoginServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping( value = "/baseLogins")
public class LoginController {

    @Autowired
    LoginServiceimpl loginServiceimpl;

    @GetMapping(value = "/list")
    public String listLogins(Model theMode ){
        List<LoginModels> listLogin = loginServiceimpl.findAllLogins();
        theMode.addAttribute("logins",listLogin);
        return "list-logins";
    }

    @GetMapping(value = "/showFormForAdd")
    public String addAllLogins(Model theModel){
        LoginModels loginModels = new LoginModels();
        theModel.addAttribute("logins",loginModels);
        return "form-logins";
    }

    @PostMapping("/save")
    @Transactional
    public String saveUser(@ModelAttribute("logins") LoginModels userModels) {
        loginServiceimpl.save(userModels);
        return "redirect:/baseLogins/list";
    }

    @GetMapping(value = "/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Optional<LoginModels> login = loginServiceimpl.findById(id);
        if (login.isPresent()) {
            model.addAttribute("logins", login.get());
            return "form-logins";
        } else {
            return "redirect:/baseLogins/list";
        }
    }
    @GetMapping("/showFromDelete/{id}")
    public String showFromforDelete(@PathVariable int id) {
        loginServiceimpl.deleteById(id);
        return "redirect:/baseLogins/list";
    }
//    @GetMapping("/showFromforDelete")
//    public String showFromforDelete(@RequestParam("loginId") int theId){
//        LoginModels loginModels = loginServiceimpl.findById(theId);
//        loginServiceimpl.deleteById(theId);
//    }
}
