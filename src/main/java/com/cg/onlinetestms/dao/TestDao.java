package com.cg.onlinetestms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinetestms.entities.Test;

@Repository
public interface TestDao extends JpaRepository<Test, Integer> {

}
