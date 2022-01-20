package dao;

import java.util.List;

import javax.ejb.Local;

import entity.SmartPhone;
@Local
public interface ISmartPhoneLocal {
	
	void create(SmartPhone smartphone);
	
	List<SmartPhone>findAll();
	
	void deleteById(long id);
	
	void update(SmartPhone smartphone);
	
	SmartPhone findById(long id);
}
