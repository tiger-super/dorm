package tiger.dorm.entity;

public class NetWorkAddress {
	// ip地址
	private String ipAddress;
	// 子网掩码
	private String subnet;
	// 默认网关
	private String defaultNet;
	// 首选dns
	private String firstDns;
	// 备用dns
	private String spareDns;
	// 上次扣费时间
	private String lastCastTime;
	// 网费所省余额
	private int balance;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}

	public String getDefaultNet() {
		return defaultNet;
	}

	public void setDefaultNet(String defaultNet) {
		this.defaultNet = defaultNet;
	}

	public String getFirstDns() {
		return firstDns;
	}

	public void setFirstDns(String firstDns) {
		this.firstDns = firstDns;
	}

	public String getSpareDns() {
		return spareDns;
	}

	public void setSpareDns(String spareDns) {
		this.spareDns = spareDns;
	}

	public String getLastCastTime() {
		return lastCastTime;
	}

	public void setLastCastTime(String lastCastTime) {
		this.lastCastTime = lastCastTime;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "NetWorkAddress [ipAddress=" + ipAddress + ", subnet=" + subnet + ", defaultNet=" + defaultNet
				+ ", firstDns=" + firstDns + ", spareDns=" + spareDns + ", lastCastTime=" + lastCastTime + ", balance="
				+ balance + "]";
	}

}
