package com.libwiz.libwiz.repository;

import com.libwiz.libwiz.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
