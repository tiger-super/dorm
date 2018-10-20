package tiger.dorm.entity;

public class Housemaster {
	// 编号
    private String housematserId;
    // 姓名
    private String housematserName;
    // 性别
    private String housematserSex;
    // 身份证
    private String idCard;
    // 名族
    private String nameFamily;
    // 电话
    private String phone;
	public String getHousematserId() {
		return housematserId;
	}
	public void setHousematserId(String housematserId) {
		this.housematserId = housematserId;
	}
	public String getHousematserName() {
		return housematserName;
	}
	public void setHousematserName(String housematserName) {
		this.housematserName = housematserName;
	}
	public String getHousematserSex() {
		return housematserSex;
	}
	public void setHousematserSex(String housematserSex) {
		this.housematserSex = housematserSex;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getNameFamily() {
		return nameFamily;
	}
	public void setNameFamily(String nameFamily) {
		this.nameFamily = nameFamily;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Housemaster [housematserId=" + housematserId + ", housematserName=" + housematserName
				+ ", housematserSex=" + housematserSex + ", idCard=" + idCard + ", nameFamily=" + nameFamily
				+ ", phone=" + phone + "]";
	}
    
}
