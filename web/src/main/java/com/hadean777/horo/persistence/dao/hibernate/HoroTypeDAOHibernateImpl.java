package com.hadean777.horo.persistence.dao.hibernate;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.hadean777.horo.persistence.dao.HoroTypeDAO;
import com.hadean777.horo.persistence.pojo.HoroType;

@Repository("horoTypeDao")
@Transactional
public class HoroTypeDAOHibernateImpl extends GenericDAOHibernateImpl<HoroType, Long> 
implements HoroTypeDAO {


}
