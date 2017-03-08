package com.myproject.poverty.console.repository;

import com.myproject.poverty.console.model.BasicUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by miracle on 2017/2/28.
 */
public interface BasicUserRepository extends JpaRepository<BasicUser, Integer>, JpaSpecificationExecutor<BasicUser> {

    List<BasicUser> findByUserAccount(String userAccount);

}
