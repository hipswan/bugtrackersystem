package com.touchcode.bugtrackersystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.touchcode.bugtrackersystem.entity.Bugs;

public interface BugRepository  extends JpaRepository<Bugs, Integer>{
	// add a method to sort by last name
//		public List<Employee> findAllByOrderByLastNameAsc();
//
//		// add a method to search by first name and last name
//		public List<Employee> findByFirstNameContainsAndLastNameContainsAllIgnoreCase(
//										String theFirstName, String theLastName);
//		
}
