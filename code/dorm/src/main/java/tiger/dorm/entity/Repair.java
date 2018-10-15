package tiger.dorm.entity;

public class Repair {
	 // 维修单号
     private String repairId;
     // 宿舍地址
     private String dormAddress;
     // 宿舍房间号
     private String dormNo;
     //申请人姓名
     private String repairApplyName;
     // 申请人的电话
     private String repairApplyPhone;
     // 要维修的设备
     private String repairInstrument;
     // 维修原因
     private String repairReason;
     // 维修状态，有两种0，表示待处理，1表示处理完毕
     private int repairSituation;
     // 维修单申请的时间
     private String applyTime;
     // 维修完成的时间
     private String handleTime;
	public String getRepairId() {
		return repairId;
	}
	public void setRepairId(String repairId) {
		this.repairId = repairId;
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
	public String getRepairApplyName() {
		return repairApplyName;
	}
	public void setRepairApplyName(String repairApplyName) {
		this.repairApplyName = repairApplyName;
	}
	public String getRepairApplyPhone() {
		return repairApplyPhone;
	}
	public void setRepairApplyPhone(String repairApplyPhone) {
		this.repairApplyPhone = repairApplyPhone;
	}
	public String getRepairInstrument() {
		return repairInstrument;
	}
	public void setRepairInstrument(String repairInstrument) {
		this.repairInstrument = repairInstrument;
	}
	public String getRepairReason() {
		return repairReason;
	}
	public void setRepairReason(String repairReason) {
		this.repairReason = repairReason;
	}
	public int getRepairSituation() {
		return repairSituation;
	}
	public void setRepairSituation(int repairSituation) {
		this.repairSituation = repairSituation;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getHandleTime() {
		return handleTime;
	}
	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}
	@Override
	public String toString() {
		return "Repair [repairId=" + repairId + ", dormAddress=" + dormAddress + ", dormNo=" + dormNo
				+ ", repairApplyName=" + repairApplyName + ", repairApplyPhone=" + repairApplyPhone
				+ ", repairInstrument=" + repairInstrument + ", repairReason=" + repairReason + ", repairSituation="
				+ repairSituation + ", applyTime=" + applyTime + ", handleTime=" + handleTime + "]";
	}
}
