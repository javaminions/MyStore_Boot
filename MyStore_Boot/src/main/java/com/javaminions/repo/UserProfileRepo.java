package com.javaminions.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaminions.pojos.UserProfile;

public interface UserProfileRepo extends JpaRepository<UserProfile, Integer>{

}
