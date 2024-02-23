package com.learnAloneJavaAvanced.CRUD.Alone.repository;

import com.learnAloneJavaAvanced.CRUD.Alone.models.LoginModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginModels, Integer> {
}
