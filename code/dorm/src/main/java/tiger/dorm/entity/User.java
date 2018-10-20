package tiger.dorm.entity;

import java.io.Serializable;

public class User implements Serializable{
	private String uName;
	private String uId;
	private String uPassword;
	private String uType;

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuType() {
		return uType;
	}

	public void setuType(String uType) {
		this.uType = uType;
	}

	@Override
	public String toString() {
		return "User [uName=" + uName + ", uId=" + uId + ", uPassword=" + uPassword + ", uType=" + uType + "]";
	}

}
