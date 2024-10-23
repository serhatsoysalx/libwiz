package com.libwiz.libwiz.aop.repository;

import com.libwiz.libwiz.aop.entity.UserRegistrationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationInfoRepository extends JpaRepository<UserRegistrationInfo, Long> {
}
