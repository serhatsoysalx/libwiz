package com.libwiz.libwiz.repository;

import com.libwiz.libwiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
