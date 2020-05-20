package com.javaminions.repo;

import org.springframework.data.repository.CrudRepository;

import com.javaminions.pojos.UserProfile;

public interface UserProfileRepo extends CrudRepository<UserProfile, Integer>{

}
