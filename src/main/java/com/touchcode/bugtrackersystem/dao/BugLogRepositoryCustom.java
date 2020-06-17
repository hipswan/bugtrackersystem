package com.touchcode.bugtrackersystem.dao;

import java.util.List;

import com.touchcode.bugtrackersystem.entity.BugLog;

public interface BugLogRepositoryCustom {

	List<BugLog> findLogFor(int theBugId);
}
