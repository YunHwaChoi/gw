package com.dk.groupware.member.model;

public class Member {
	
	private int id;
	private String pw, name, dep, tel, phone;
	private int manager;
	private int pno;
	private String position;
	private String encId;
	
	public Member(){}

	// 사원 리스트용 생성자
	public Member(int id, String name, String dep){
		this.id=id;
		this.name=name;
		this.dep=dep;
	}
	
	// 사원 정보보기용 생성자
	public Member(int id, String name, String dep, String tel, String phone, int manager){
		this.id=id;
		this.name=name;
		this.dep=dep;
		this.tel=tel;
		this.phone=phone;
		this.manager=manager;
	}
	
//	// memberPosition 테이블 생성자 (조인 위해)
//	public Member(int pno, String position){
//		this.pno=pno;
//		this.position=position;
//	}
	
	// getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEncId() {
		return encId;
	}

	public void setEncId(String encId) {
		this.encId = encId;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", dep=" + dep + ", tel=" + tel + ", phone="
				+ phone + ", manager=" + manager + ", pno=" + pno + ", position=" + position + ", encId=" + encId + "]";
	}

}
