package com.hadean777.horo.persistence.dao.hibernate;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hadean777.horo.persistence.dao.HoroTextDAO;
import com.hadean777.horo.persistence.pojo.HoroText;

@Repository("horoTextDao")
@Transactional
public class HoroTextDAOHibernateImpl extends GenericDAOHibernateImpl<HoroText, Long> 
implements HoroTextDAO {


}