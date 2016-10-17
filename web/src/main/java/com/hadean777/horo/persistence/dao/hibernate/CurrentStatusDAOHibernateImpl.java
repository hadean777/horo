package com.hadean777.horo.persistence.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hadean777.horo.exception.DAOException;
import com.hadean777.horo.persistence.dao.CurrentStatusDAO;
import com.hadean777.horo.persistence.pojo.CurrentStatus;

@Repository("currentStatusDao")
@Transactional
public class CurrentStatusDAOHibernateImpl extends GenericDAOHibernateImpl<CurrentStatus, Long> 
implements CurrentStatusDAO {

	@SuppressWarnings("unchecked")
	public List<CurrentStatus> getCurrentStatuses() throws DAOException{
		
        List<CurrentStatus> currentStatusList = null;
        try {
            Query query = getSession().createQuery("from CurrentStatus");
            currentStatusList = (List<CurrentStatus>) query.list();
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
        return currentStatusList;
	}


}