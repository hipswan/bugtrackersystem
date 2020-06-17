package com.touchcode.bugtrackersystem.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touchcode.bugtrackersystem.dao.BugLogRepository;
import com.touchcode.bugtrackersystem.dao.BugRepository;
import com.touchcode.bugtrackersystem.entity.BugLog;
import com.touchcode.bugtrackersystem.entity.Bugs;

@Service
public class BugTrackerServiceImpl implements BugService {
	@Autowired
	private BugRepository bugrepository;

	@Autowired
	private BugLogRepository buglogrepository;

	@Override
	public List<Bugs> findAll() {
		return bugrepository.findAll();
	}

	@Override
	public Bugs findById(int theId) {
		Optional<Bugs> result = bugrepository.findById(theId);

		Bugs theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we didn't find the bug
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theEmployee;
	}

	@Override
	public Bugs save(Bugs theBug) {
		return bugrepository.save(theBug);
	}

	@Override
	public void deleteById(int theId) {
		bugrepository.deleteById(theId);
	}

	@Override
	public void saveBugLog(BugLog theBugLog) {
		// TODO Auto-generated method stub
		buglogrepository.save(theBugLog);
	}

	@Override
	@Transactional
	public List<BugLog> findLogFor(int bugId) {
		// TODO Auto-generated method stub

		return buglogrepository.findLogFor(bugId);
	}

//	@Override
//	public List<Bugs> searchBy(String theFirstName, String theLastName) {
//
//		return bugrepository.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(theFirstName, theLastName);
//	}

}
