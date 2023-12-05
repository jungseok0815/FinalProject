package com.kh.finalProject.member.model.vo;

public class SportInfo {

	private String sportLever;
	private int sportScore;
	private int sportCount;
	private String style;
	private String skill;
	private int userNo;
	private int categoryNum;
	
	
	
	
	
	public SportInfo() {
		super();
	}

	public SportInfo(String sportLever, int sportScore, int sportCount, String style, String skill, int userNo,
			int categoryNum) {
		super();
		this.sportLever = sportLever;
		this.sportScore = sportScore;
		this.sportCount = sportCount;
		this.style = style;
		this.skill = skill;
		this.userNo = userNo;
		this.categoryNum = categoryNum;
	}
	
	public String getSportLever() {
		return sportLever;
	}
	public void setSportLever(String sportLever) {
		this.sportLever = sportLever;
	}
	public int getSportScore() {
		return sportScore;
	}
	public void setSportScore(int sportScore) {
		this.sportScore = sportScore;
	}
	public int getSportCount() {
		return sportCount;
	}
	public void setSportCount(int sportCount) {
		this.sportCount = sportCount;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	@Override
	public String toString() {
		return "SportInfo [sportLever=" + sportLever + ", sportScore=" + sportScore + ", sportCount=" + sportCount
				+ ", style=" + style + ", skill=" + skill + ", userNo=" + userNo + ", categoryNum=" + categoryNum + "]";
	}
	
	
	
	
}