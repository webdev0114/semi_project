package dto;

import java.sql.Timestamp;

public class R_DTO {

	private int r_num;
	private String id;
	private String r_title;
	private String r_content;
	private String r_file;
	private int r_readcnt;
	private Timestamp r_reg;
	private int r_ref;
	private int r_step;
	private int r_lvl;
	private String r_pw;

	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getR_file() {
		return r_file;
	}
	public void setR_file(String r_file) {
		this.r_file = r_file;
	}
	public int getR_readcnt() {
		return r_readcnt;
	}
	public void setR_readcnt(int r_readcnt) {
		this.r_readcnt = r_readcnt;
	}
	public Timestamp getR_reg() {
		return r_reg;
	}
	public void setR_reg(Timestamp r_reg) {
		this.r_reg = r_reg;
	}
	public int getR_ref() {
		return r_ref;
	}
	public void setR_ref(int r_ref) {
		this.r_ref = r_ref;
	}
	public int getR_step() {
		return r_step;
	}
	public void setR_step(int r_step) {
		this.r_step = r_step;
	}
	public int getR_lvl() {
		return r_lvl;
	}
	public void setR_lvl(int r_lvl) {
		this.r_lvl = r_lvl;
	}
	public String getR_pw() {
		return r_pw;
	}
	public void setR_pw(String r_pw) {
		this.r_pw = r_pw;
	}
	

}
