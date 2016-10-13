package com.hadean777.horo.persistence.dao.hibernate;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hadean777.horo.persistence.dao.StatusHistoryDAO;
import com.hadean777.horo.persistence.pojo.StatusHistory;

@Repository("statusHistoryDao")
@Transactional
public class StatusHistoryDAOHibernateImpl extends GenericDAOHibernateImpl<StatusHistory, Long> 
implements StatusHistoryDAO {


}