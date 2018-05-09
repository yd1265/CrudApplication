package org.lms.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date duedate;
	private boolean finished;
	
	public Tasks() {
		
	}
	
	public Tasks(String name, String description, Date duedate, boolean finished) {
		super();
		this.name = name;
		this.description = description;
		this.duedate = duedate;
		this.finished = finished;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	@Override
	public String toString() {
		return "Tasks [id=" + id + ", name=" + name + ", description=" + description + ", duedate=" + duedate + ", finished="
				+ finished + "]";
	}
	
	
}
