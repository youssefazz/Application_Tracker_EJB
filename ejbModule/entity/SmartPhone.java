package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SmartPhone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4306666097252500126L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String imei;
	
	@ManyToOne
	@JoinColumn(name = "User_id")
	private User user;
//	@OneToMany
//	private List<Position>positions;

	public SmartPhone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SmartPhone(String imei, User user) {
		super();
		this.imei = imei;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SmartPhone [id=" + id + ", imei=" + imei + ", user=" + user + "]";
	}
	
	
	
}
