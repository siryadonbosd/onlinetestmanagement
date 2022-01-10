package com.cg.onlinetestms.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "test_hib1")

public class Test {
	@Id
	@GeneratedValue
	private int testId;
	private String testTitle;
	@Column(name = "duration_test")
	private double testDuration;
	@OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
	private Set<Question> testQuestions;
	@Column(name = "Start_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	@Column(name = "end_Time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public double getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(double testDuration) {
		this.testDuration = testDuration;
	}

	public Set<Question> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(Set<Question> testQuestions) {
		this.testQuestions = testQuestions;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration
				+ ", testQuestions=" + testQuestions + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	public Test(int testId, String testTitle, double testDuration, Set<Question> testQuestions, Date startTime,
			Date endTime) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testQuestions = testQuestions;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void update(Test test) {
		this.testId = test.getTestId();
		this.testTitle = test.getTestTitle();
		this.testDuration = test.getTestDuration();
		this.testQuestions = test.getTestQuestions();
		this.startTime = test.getStartTime();
		this.endTime = test.getEndTime();

	}

}
