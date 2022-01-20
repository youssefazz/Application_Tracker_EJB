package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.ISmartPhoneLocal;
import dao.ISmartPhoneRemote;
import entity.SmartPhone;

@Stateless(name = "smartphone")
public class SmartPhoneDao implements ISmartPhoneLocal,ISmartPhoneRemote{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(SmartPhone smartphone) {
		em.persist(smartphone);
		
	}

	@Override
	public List<SmartPhone> findAll() {
		return em.createQuery("select sp from SmartPhone sp",SmartPhone.class).getResultList();
	}

	@Override
	public void deleteById(long id) {
		SmartPhone sp=findById(id);
		if(sp != null) {
			em.remove(em.contains(sp) ? sp : em.merge(sp));
		}
	}

	@Override
	public void update(SmartPhone smartphone) {
		SmartPhone sp=findById(smartphone.getId());
		if(sp != null) {
			sp.setImei(smartphone.getImei());
			em.persist(em.contains(sp) ? sp : em.merge(sp));
		}
		
	}

	@Override
	public SmartPhone findById(long id) {
		return em.find(SmartPhone.class, id);
	}

}
