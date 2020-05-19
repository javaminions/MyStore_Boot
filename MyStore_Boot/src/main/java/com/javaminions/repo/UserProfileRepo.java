package com.javaminions.repo;

import org.springframework.data.repository.CrudRepository;

import com.javaminions.model.UserProfile;

public interface UserProfileRepo extends CrudRepository<UserProfile, Integer>{

}
