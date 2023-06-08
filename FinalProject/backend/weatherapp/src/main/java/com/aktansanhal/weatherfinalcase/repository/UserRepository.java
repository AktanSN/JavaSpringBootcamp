package com.aktansanhal.weatherfinalcase.repository;

import com.aktansanhal.weatherfinalcase.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    List<User> getByUsernameStartsWith(String username);

    List<User> getByUsernameContaining(String username);

    List<User> getAllByOrderByUsernameAsc();

}
