package com.hadean777.horo.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hadean777.horo.persistence.dao.*;

/**
 * Facade for all DAO interfaces
 * 
 * @author Created by hadean777 <br>
 * @author Last modified by $Author: hadean777 $ <br>
 * @author Last modified on $Date: 2016-10-13 18:30:00 +0200 (Thu, 13 Oct 2016) $ at revision $Revision:   $ <br>
 */
@Component("daoFacade")
public class DaoFacade {	
	
	@Autowired
	private SignDAO signDao;
	
	@Autowired
	private HoroTypeDAO horoTypeDao;
	
	@Autowired
	private HoroTextDAO horoTextDao;
	
	@Autowired
	private StatusHistoryDAO statusHistoryDao;
	
	@Autowired
	private CurrentStatusDAO currentStatusDao;
	
	
	
	public SignDAO getSignDao() {
		return signDao;
	}
	
	public HoroTypeDAO getHoroTypeDao() {
		return horoTypeDao;
	}
	
	public HoroTextDAO getHoroTextDao() {
		return horoTextDao;
	}
	
	public StatusHistoryDAO getStatusHistoryDao() {
		return statusHistoryDao;
	}
	
	public CurrentStatusDAO getCurrentStatusDao() {
		return currentStatusDao;
	}

	
}
