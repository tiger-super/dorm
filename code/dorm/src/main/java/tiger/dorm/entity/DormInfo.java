package tiger.dorm.entity;

public class DormInfo {
	// 入住时间
	private String checkInTime;
	// 床位
	private String bedNo;
	// 入住情况
	private String checkSituation;
	// 入住的学生
	private Student student;
    // 网络地址
	private NetWorkAddress netWorkAddress;
	
	public NetWorkAddress getNetWorkAddress() {
		return netWorkAddress;
	}

	public void setNetWorkAddress(NetWorkAddress netWorkAddress) {
		this.netWorkAddress = netWorkAddress;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public String getCheckSituation() {
		return checkSituation;
	}

	public void setCheckSituation(String checkSituation) {
		this.checkSituation = checkSituation;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "DormInfo [checkInTime=" + checkInTime + ", bedNo=" + bedNo + ", checkSituation=" + checkSituation
				+ ", student=" + student + ", netWorkAddress=" + netWorkAddress + "]";
	}
}
