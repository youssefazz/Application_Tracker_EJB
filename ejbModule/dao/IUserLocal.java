package dao;

import java.util.List;

import javax.ejb.Local;

import entity.User;

@Local
public interface IUserLocal {
	
	void create(User user);
	
	List<User>findAll();
	
	void deleteById(long id);
	
	void update(User user);
	
	User findById(long id);
	
}
