package com.hadean777.horo.persistence.dao.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hadean777.horo.exception.DAOException;
import com.hadean777.horo.persistence.dao.SignDAO;
import com.hadean777.horo.persistence.pojo.Sign;

@Repository("signDao")
@Transactional
public class SignDAOHibernateImpl extends GenericDAOHibernateImpl<Sign, Long> 
implements SignDAO {

	@SuppressWarnings("unchecked")
	public List<Sign> getAllSigns() throws DAOException{
		
        List<Sign> signList = null;
        try {
            Query query = getSession().createQuery("from Sign");
            signList = (List<Sign>) query.list();
        } catch (HibernateException e) {
            throw new DAOException(e);
        }
        return signList;
	}

}
