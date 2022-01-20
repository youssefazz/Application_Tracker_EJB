package dao;

import java.util.List;

import javax.ejb.Remote;

import entity.SmartPhone;
@Remote
public interface ISmartPhoneRemote {
	void create(SmartPhone smartphone);
	
	List<SmartPhone>findAll();
	
	void deleteById(long id);
	
	void update(SmartPhone smartphone);
	
	SmartPhone findById(long id);
}
