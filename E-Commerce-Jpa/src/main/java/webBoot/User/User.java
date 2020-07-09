package webBoot.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uss")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	private String userName;
	
	private String PASSWORD;
	
	private boolean ACTIVE;
	
	private String ROLES;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;
	}

	public boolean isACTIVE() {
		return ACTIVE;
	}

	public void setACTIVE(boolean ACTIVE) {
		this.ACTIVE = ACTIVE;
	}

	public String getROLES() {
		return ROLES;
	}

	public void setROLES(String ROLES) {
		this.ROLES = ROLES;
	}

	
}
