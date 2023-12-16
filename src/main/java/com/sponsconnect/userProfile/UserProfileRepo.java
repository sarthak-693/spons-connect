package com.sponsconnect.userProfile;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {

    List<UserProfile>  findByInstitutionNameContaining(String institutionName);

}
