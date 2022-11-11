package dto;

import java.sql.Timestamp;

public class Q_DTO {

	private int q_num;
	private String q_title;
	private String q_content;
	private int q_readcnt;
	private Timestamp q_reg;
	private int q_ref;
	private int q_step;
	private int q_lvl;
	private String id;
	private String q_pw;
	
	public int getQ_num() {
		return q_num;
	}
	public void setQ_num(int q_num) {
		this.q_num = q_num;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public int getQ_readcnt() {
		return q_readcnt;
	}
	public void setQ_readcnt(int q_readcnt) {
		this.q_readcnt = q_readcnt;
	}
	public Timestamp getQ_reg() {
		return q_reg;
	}
	public void setQ_reg(Timestamp q_reg) {
		this.q_reg = q_reg;
	}
	public int getQ_ref() {
		return q_ref;
	}
	public void setQ_ref(int q_ref) {
		this.q_ref = q_ref;
	}
	public int getQ_step() {
		return q_step;
	}
	public void setQ_step(int q_step) {
		this.q_step = q_step;
	}
	public int getQ_lvl() {
		return q_lvl;
	}
	public void setQ_lvl(int q_lvl) {
		this.q_lvl = q_lvl;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getQ_pw() {
		return q_pw;
	}
	public void setQ_pw(String q_pw) {
		this.q_pw = q_pw;
	}
	
	
	
}
