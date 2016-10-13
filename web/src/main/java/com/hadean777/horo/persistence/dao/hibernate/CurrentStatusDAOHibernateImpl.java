package com.hadean777.horo.persistence.dao.hibernate;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hadean777.horo.persistence.dao.CurrentStatusDAO;
import com.hadean777.horo.persistence.pojo.CurrentStatus;

@Repository("currentStatusDao")
@Transactional
public class CurrentStatusDAOHibernateImpl extends GenericDAOHibernateImpl<CurrentStatus, Long> 
implements CurrentStatusDAO {


}