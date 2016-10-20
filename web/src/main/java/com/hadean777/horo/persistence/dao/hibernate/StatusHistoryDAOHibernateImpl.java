package com.hadean777.horo.persistence.dao.hibernate;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hadean777.horo.exception.DAOException;
import com.hadean777.horo.persistence.dao.StatusHistoryDAO;
import com.hadean777.horo.persistence.pojo.StatusHistory;

@Repository("statusHistoryDao")
@Transactional
public class StatusHistoryDAOHibernateImpl extends GenericDAOHibernateImpl<StatusHistory, Long> 
implements StatusHistoryDAO {

	@SuppressWarnings("unchecked")
	public List<StatusHistory> getDailyStatusHistoryListByInterval(Date beginDate, Date endDate) throws DAOException{
		//TODO: Complete this method		
        List<StatusHistory> statusHistoryList = null;
        try {
            Query query = getSession().createQuery("from StatusHistory");
            statusHistoryList = (List<StatusHistory>) query.list();
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
        return statusHistoryList;
	}
	
	public List<StatusHistory> getDailyStatusHistoryListByDate(Date p_date) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<StatusHistory> getWeekyStatusHistoryListByDate(Date p_date) throws DAOException{
		//TODO: Complete this method
        return null;
	}

	public List<StatusHistory> getMonthyStatusHistoryListByDate(Date p_date) throws DAOException{
		//TODO: Complete this method
		return null;
	}
	
	public List<StatusHistory> getYearlyStatusHistoryListByDate(Date p_date) throws DAOException{
		//TODO: Complete this method
		return null;
	}

}