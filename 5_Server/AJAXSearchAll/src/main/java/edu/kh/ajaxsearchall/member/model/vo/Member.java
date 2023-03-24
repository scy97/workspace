package edu.kh.ajaxsearchall.member.model.vo;

public class Member {
	private int memberNo;
	private String memberEmail;
	private String memberNickname;
	
	public Member() {

	}

	public Member(int memberNo, String memberEmail, String memberNickname) {
		super();
		this.memberNo = memberNo;
		this.memberEmail = memberEmail;
		this.memberNickname = memberNickname;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberEmail=" + memberEmail + ", memberNickname=" + memberNickname
				+ "]";
	}
	
	
}
