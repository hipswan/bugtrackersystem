package com.touchcode.bugtrackersystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.touchcode.bugtrackersystem.entity.BugLog;

@Repository
public interface BugLogRepository extends JpaRepository<BugLog, Integer>, BugLogRepositoryCustom {

	
}
