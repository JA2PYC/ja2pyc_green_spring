package org.duckdns.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TodoDTO {
	private String title;
	private Date dueDate;
//	@DateTimeFormat(pattern ="yyyyMMdd")
//	private Date lastDate;
	
//	public Date getLastDate() {
//		return lastDate;
//	}
//	public void setLastDate(Date lastDate) {
//		this.lastDate = lastDate;
//	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
//		return "TodoDTO [title=" + title + ", dueDate=" + dueDate + ", lastDate=" + lastDate + "]";
		return "TodoDTO [title=" + title + ", dueDate=" + dueDate + "]";
	}
	
}
