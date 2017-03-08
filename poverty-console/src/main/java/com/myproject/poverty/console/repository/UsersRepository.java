package com.myproject.poverty.console.repository;

import com.myproject.poverty.console.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by miracle on 2017/2/28.
 */
public interface UsersRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

    List<Users> findByUsername(String username);

}
