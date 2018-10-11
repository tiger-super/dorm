package tiger.dorm.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Dorm {
	// 宿舍编号
	private String dormId;
	// 宿舍地址
	private String dormAddress;
	// 宿舍房间号
	private String dormNo;
	// 宿舍可容纳人数
	private int dormHold;
	// 宿舍是否在使用
	private int dormStatus;
	// 宿舍入住人数
	private int dormUsePerson;
	// 该宿舍入住的所有学生
	private List<DormInfo> dormInfos;
	// 仪器
	private List<Device> devices;

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public List<DormInfo> getDormInfos() {
		return dormInfos;
	}

	public void setDormInfos(List<DormInfo> dormInfos) {
		this.dormInfos = dormInfos;
	}

	public String getDormId() {
		return dormId;
	}

	public void setDormId(String dormId) {
		this.dormId = dormId;
	}

	public String getDormAddress() {
		return dormAddress;
	}

	public void setDormAddress(String dormAddress) {
		this.dormAddress = dormAddress;
	}

	public String getDormNo() {
		return dormNo;
	}

	public void setDormNo(String dormNo) {
		this.dormNo = dormNo;
	}

	public int getDormHold() {
		return dormHold;
	}

	public void setDormHold(int dormHold) {
		this.dormHold = dormHold;
	}

	public int getDormStatus() {
		return dormStatus;
	}

	public void setDormStatus(int dormStatus) {
		this.dormStatus = dormStatus;
	}

	public int getDormUsePerson() {
		return dormUsePerson;
	}

	public void setDormUsePerson(int dormUsePerson) {
		this.dormUsePerson = dormUsePerson;
	}

	@Override
	public String toString() {
		return "Dorm [dormId=" + dormId + ", dormAddress=" + dormAddress + ", dormNo=" + dormNo + ", dormHold="
				+ dormHold + ", dormStatus=" + dormStatus + ", dormUsePerson=" + dormUsePerson + "]";
	}

}
