package com.application.biz.impl;

import java.util.List;

import com.application.biz.PraiseBiz;
import com.application.dao.PraiseDao;
import com.application.dao.impl.PraiseDaoImpl;
import com.application.entity.Praise;

public class PraiseBizImpl implements PraiseBiz {

	private PraiseDao praiseDao = new PraiseDaoImpl();
	
	private Praise praizeEntity;

	public boolean addPraise(Praise praise) {
		return praiseDao.addPraise(praise);
	}

	public boolean updatePraise(Praise praise) {
		return praiseDao.updatePraise(praise);
	}

	public boolean deletePraise(int id, int blessingId) {
		return praiseDao.deletePraise(id, blessingId);
	}

	public Praise fetchPraiseByBlessingId(int blessingId, String ip) {
		return praiseDao.fetchPraiseByBlessingId(blessingId, ip);
	}

	public boolean fetchPraiseByBlessingIdForBoolean(int blessingId, String ip) {
		setPraizeEntity(praiseDao.fetchPraiseByBlessingId(blessingId, ip));
		if (praizeEntity != null) {
			return true;
		}
		return false;
	}

	public List<Praise> fetchPraiseByIp(String ip) {
		return praiseDao.fetchPraise(ip);
	}

	public Praise getPraizeEntity() {
		return praizeEntity;
	}

	public void setPraizeEntity(Praise praizeEntity) {
		this.praizeEntity = praizeEntity;
	}

}
