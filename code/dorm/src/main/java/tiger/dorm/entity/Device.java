package tiger.dorm.entity;

public class Device {
	// 仪器名称
    private String deviceName;
    // 仪器数量
    private String deviceNumber;
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	@Override
	public String toString() {
		return "Device [deviceName=" + deviceName + ", deviceNumber=" + deviceNumber + "]";
	}
    
}
