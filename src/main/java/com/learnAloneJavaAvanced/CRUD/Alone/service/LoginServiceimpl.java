package com.learnAloneJavaAvanced.CRUD.Alone.service;

import com.learnAloneJavaAvanced.CRUD.Alone.models.LoginModels;
import com.learnAloneJavaAvanced.CRUD.Alone.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class LoginServiceimpl  {

    @Autowired
    LoginRepository loginRepository;

    public List<LoginModels> findAllLogins() {
        return loginRepository.findAll();
    }
    @Transactional
    public LoginModels save(LoginModels loginModels) {
        return loginRepository.save(loginModels);
    }
    public Optional<LoginModels> findById(int id){
        return loginRepository.findById(id);
    }
    public void deleteById(int id){
        loginRepository.deleteById(id);
    }
}



