package com.cg.onlinetestms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinetestms.dto.UserDetails;
@Repository
public interface UserRegistrationDao extends JpaRepository<UserDetails, String> {

}
