package com.touchcode.bugtrackersystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.touchcode.bugtrackersystem.dao.BugRepository;
import com.touchcode.bugtrackersystem.entity.Bugs;

@Service
public class BugTrackerServiceImplementation implements BugService {

	private BugRepository bugrepository;

	@Autowired
	public BugTrackerServiceImplementation(BugRepository bugrepository) {
		this.bugrepository = bugrepository;
	}

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
	public void save(Bugs theBug) {
		bugrepository.save(theBug);
	}

	@Override
	public void deleteById(int theId) {
		bugrepository.deleteById(theId);
	}


//	@Override
//	public List<Bugs> searchBy(String theFirstName, String theLastName) {
//
//		return bugrepository.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(theFirstName, theLastName);
//	}

}
