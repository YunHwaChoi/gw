package com.dk.groupware.draft.model;

public class Draft {
	private int no;
	private String title;
	private String content;
	private String drafter;
	private String dep;
	private String signer1;
	private String signer2;
	private String signer3;
	private String isSign1;
	private String isSign2;
	private String isSign3;
	private String regDate;
	private String signerName2;
	private String signerName3;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDrafter() {
		return drafter;
	}

	public void setDrafter(String drafter) {
		this.drafter = drafter;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getSigner1() {
		return signer1;
	}

	public void setSigner1(String signer1) {
		this.signer1 = signer1;
	}

	public String getSigner2() {
		return signer2;
	}

	public void setSigner2(String signer2) {
		this.signer2 = signer2;
	}

	public String getSigner3() {
		return signer3;
	}

	public void setSigner3(String signer3) {
		this.signer3 = signer3;
	}

	public String getIsSign1() {
		return isSign1;
	}

	public void setIsSign1(String isSign1) {
		this.isSign1 = isSign1;
	}

	public String getIsSign2() {
		return isSign2;
	}

	public void setIsSign2(String isSign2) {
		this.isSign2 = isSign2;
	}

	public String getIsSign3() {
		return isSign3;
	}

	public void setIsSign3(String isSign3) {
		this.isSign3 = isSign3;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getSignerName2() {
		return signerName2;
	}

	public void setSignerName2(String signerName2) {
		this.signerName2 = signerName2;
	}

	public String getSignerName3() {
		return signerName3;
	}

	public void setSignerName3(String signerName3) {
		this.signerName3 = signerName3;
	}

	@Override
	public String toString() {
		return "Draft [no=" + no + ", title=" + title + ", content=" + content + ", drafter=" + drafter + ", dep="
				+ dep + ", signer1=" + signer1 + ", signer2=" + signer2 + ", signer3=" + signer3 + ", isSign1="
				+ isSign1 + ", isSign2=" + isSign2 + ", isSign3=" + isSign3 + ", regDate=" + regDate + ", signerName2="
				+ signerName2 + ", signerName3=" + signerName3 + "]";
	}

}
