package dao;

import java.util.List;

import javax.ejb.Remote;

import entity.User;

@Remote
public interface IUserRemote {
	
	void create(User user);
	
	List<User>findAll();
	
	void deleteById(long id);
	
	void update(User user);
	
	User findById(long id);
}
