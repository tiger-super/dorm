package tiger.dorm.entity;

public class Teacher {
	// 编号
    private String teaId;
    // 姓名
    private String teaName;
    // 性别
    private String teaSex;
    // 身份证
    private String idCard;
    // 名族
    private String nameFamily;
    // 电话
    private String phone;
    
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTeaId() {
		return teaId;
	}
	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}
	
	public String getTeaSex() {
		return teaSex;
	}
	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
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
		return "Teacher [teaId=" + teaId + ", teaName=" + teaName + ", teaSex=" + teaSex + ", idCard=" + idCard
				+ ", nameFamily=" + nameFamily + ", phone=" + phone + "]";
	}
}
