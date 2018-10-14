package tiger.dorm.entity;

public class User {
	private String uId;
	private String uPassword;
	private String uType;

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
		return "User [uId=" + uId + ", uPassword=" + uPassword + ", uType=" + uType + "]";
	}

}
