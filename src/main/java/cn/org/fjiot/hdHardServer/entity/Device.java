package cn.org.fjiot.hdHardServer.entity;

import cn.org.fjiot.hdHardServer.framework.BaseEntityImpl;

public class Device extends BaseEntityImpl {
	
	private String id;
	
	private String deviceNo;
	
	private String isStart;

	private String electric;

	private String startTime;

	private String updateTime;

	private String endTime;

	private String userId;

	private String roomBed;

	private String isLowElec;

	private String isLose;

	private String isError;

	private String weightSum;

	private String weightThreshold;

	private String weightCur;
	
	private String isLowLevel;
	
	private String userName;
	
	private String isPercent;
	
	private String isSuspend;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeviceNo() {
		return deviceNo;
	}

	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	public String getIsStart() {
		return isStart;
	}

	public void setIsStart(String isStart) {
		this.isStart = isStart;
	}

	public String getElectric() {
		return electric;
	}

	public void setElectric(String electric) {
		this.electric = electric;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoomBed() {
		return roomBed;
	}

	public void setRoomBed(String roomBed) {
		this.roomBed = roomBed;
	}

	public String getIsLowElec() {
		return isLowElec;
	}

	public void setIsLowElec(String isLowElec) {
		this.isLowElec = isLowElec;
	}

	public String getIsLose() {
		return isLose;
	}

	public void setIsLose(String isLose) {
		this.isLose = isLose;
	}

	public String getIsError() {
		return isError;
	}

	public void setIsError(String isError) {
		this.isError = isError;
	}

	public String getWeightSum() {
		return weightSum;
	}

	public void setWeightSum(String weightSum) {
		this.weightSum = weightSum;
	}

	public String getWeightThreshold() {
		return weightThreshold;
	}

	public void setWeightThreshold(String weightThreshold) {
		this.weightThreshold = weightThreshold;
	}

	public String getWeightCur() {
		return weightCur;
	}

	public void setWeightCur(String weightCur) {
		this.weightCur = weightCur;
	}

	public String getIsLowLevel() {
		return isLowLevel;
	}

	public void setIsLowLevel(String isLowLevel) {
		this.isLowLevel = isLowLevel;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIsPercent() {
		return isPercent;
	}

	public void setIsPercent(String isPercent) {
		this.isPercent = isPercent;
	}

	public String getIsSuspend() {
		return isSuspend;
	}

	public void setIsSuspend(String isSuspend) {
		this.isSuspend = isSuspend;
	}

}
