package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.IPositionLocal;
import dao.IPositionRemote;
import entity.Position;
@Stateless(name="position")
public class PositionDao implements IPositionLocal,IPositionRemote{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(Position position) {
		em.persist(position);
	}

	@Override
	public List<Position> findAll() {
		return em.createQuery("select p from Position p",Position.class).getResultList();
	}

	@Override
	public void deleteById(long id) {
		Position p=findById(id);
		if(p != null) {
			em.remove(em.contains(p) ? p : em.merge(p));
		}
		
	}

	@Override
	public void update(Position position) {
		Position p=findById(position.getId());
		if(p != null) {
			p.setLongitude(position.getLongitude());
			p.setLatitude(position.getLatitude());
			p.setDate(position.getDate());
			em.persist(em.contains(p) ? p : em.merge(p));
		}
	}

	@Override
	public Position findById(long id) {
		return em.find(Position.class, id);
	}
	
	@Override
	public List<Position>getPositionBetweenDate(Date d1,Date d2){
		List<Position>p=new ArrayList<Position>();
		p=em.createQuery("select p from Position p where p.date between '2021-12-21T15:50:00.015Z[UTC]'  and '2021-12-21T18:50:00.015Z[UTC]' ",Position.class).getResultList();
		return p;
	}

}
