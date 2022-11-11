package dto;

import java.sql.Timestamp;

public class RE_DTO {
	private int re_num;
	private int r_num;
	private String re_comment;
	private Timestamp re_reg;
	private String id;
	private String re_file;
	private int re_re_ref;
	private int re_re_lev;
	private int re_re_seq;
	
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public String getRe_comment() {
		return re_comment;
	}
	public void setRe_comment(String re_comment) {
		this.re_comment = re_comment;
	}
	public Timestamp getRe_reg() {
		return re_reg;
	}
	public void setRe_reg(Timestamp re_reg) {
		this.re_reg = re_reg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRe_file() {
		return re_file;
	}
	public void setRe_file(String re_file) {
		this.re_file = re_file;
	}
	public int getRe_re_ref() {
		return re_re_ref;
	}
	public void setRe_re_ref(int re_re_ref) {
		this.re_re_ref = re_re_ref;
	}
	public int getRe_re_lev() {
		return re_re_lev;
	}
	public void setRe_re_lev(int re_re_lev) {
		this.re_re_lev = re_re_lev;
	}
	public int getRe_re_seq() {
		return re_re_seq;
	}
	public void setRe_re_seq(int re_re_seq) {
		this.re_re_seq = re_re_seq;
	}
	

}
