package com.touchcode.bugtrackersystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.touchcode.bugtrackersystem.entity.BugLog;

@Repository
public class BugLogRepositoryImpl implements BugLogRepositoryCustom {
	@Autowired
	EntityManager entitymanager;

	@Override
	public List<BugLog> findLogFor(int theBugId) {
		// TODO Auto-generated method stub
		System.out.println("Inside Implementation");
		Query logquery = entitymanager.createQuery("FROM BugLog where bugId=:bugid");
		logquery.setParameter("bugid", theBugId);
//        Query query = entityManager.createNativeQuery("SELECT em.* FROM spring_data_jpa_example.employee as em "
//
//                "WHERE em.firstname LIKE ?", Employee.class);
//
//        query.setParameter(1, firstName + "%");
		List<BugLog> buglogs = logquery.getResultList();
		System.out.println(buglogs);
		return buglogs;
	}

}
