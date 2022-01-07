package com.spring.dto;

public class FilesDTO {

	private int seq;
	private String oriname;
	private String sysname;
	private int parentseq;
	public FilesDTO(int seq, String oriname, String sysname, int parentseq) {
		super();
		this.seq = seq;
		this.oriname = oriname;
		this.sysname = sysname;
		this.parentseq = parentseq;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSysname() {
		return sysname;
	}
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	public int getParentseq() {
		return parentseq;
	}
	public void setParentseq(int parentseq) {
		this.parentseq = parentseq;
	}
	
	
}
