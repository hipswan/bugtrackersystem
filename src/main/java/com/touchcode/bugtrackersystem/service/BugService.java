package com.touchcode.bugtrackersystem.service;

import java.util.List;

import com.touchcode.bugtrackersystem.entity.Bugs;

public interface BugService {

	Bugs findById(int theId);

	List<Bugs> findAll();

	void save(Bugs theBug);

	void deleteById(int theId);

}
