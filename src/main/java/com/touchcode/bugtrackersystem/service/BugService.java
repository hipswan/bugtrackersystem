package com.touchcode.bugtrackersystem.service;

import java.util.List;

import com.touchcode.bugtrackersystem.entity.BugLog;
import com.touchcode.bugtrackersystem.entity.Bugs;

public interface BugService {

	Bugs findById(int theId);

	List<Bugs> findAll();

	Bugs save(Bugs theBug);

	void deleteById(int theId);

	void saveBugLog(BugLog theBugLog);

	List<BugLog> findLogFor(int bugId);

}
