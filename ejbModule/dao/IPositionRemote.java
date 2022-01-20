package dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entity.Position;
@Remote
public interface IPositionRemote {
	
	void create(Position position);
	
	List<Position>findAll();
	
	void deleteById(long id);
	
	void update(Position position);
	
	Position findById(long id);
	
	List<Position>getPositionBetweenDate(Date d1,Date d2);
}
