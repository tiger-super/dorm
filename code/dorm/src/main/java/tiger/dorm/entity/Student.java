package tiger.dorm.entity;

public class  Student {
	// 学号
    private String stuId;
    // 姓名
    private String stuName;
    // 性别
    private String stuSex;
    // 身份证
    private String idCard;
    // 名族
    private String nameFamily;
    // 电话
    private String phone;
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getNameFamily() {
		return nameFamily;
	}
	public void setNameFamily(String nameFamily) {
		this.nameFamily = nameFamily;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuSex=" + stuSex + ", idCard=" + idCard
				+ ", nameFamily=" + nameFamily + ", phone=" + phone + "]";
	}
	
    
    
}
