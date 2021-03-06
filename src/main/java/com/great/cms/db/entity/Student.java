/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.db.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
		@NamedQuery(name = "Student.findByStudentId", query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
		@NamedQuery(name = "Student.findByRegistrationNo", query = "SELECT s FROM Student s WHERE s.registrationNo = :registrationNo"),
		@NamedQuery(name = "Student.findByEmailNo", query = "SELECT s FROM Student s WHERE s.emailNo = :emailNo"),
		@NamedQuery(name = "Student.findByContactNo", query = "SELECT s FROM Student s WHERE s.contactNo = :contactNo"),
		@NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address"),
		@NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName"),
		@NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName"),
		@NamedQuery(name = "Student.findByMaritalStatus", query = "SELECT s FROM Student s WHERE s.maritalStatus = :maritalStatus"),
		@NamedQuery(name = "Student.findByBloodGroup", query = "SELECT s FROM Student s WHERE s.bloodGroup = :bloodGroup"),
		@NamedQuery(name = "Student.findByReligion", query = "SELECT s FROM Student s WHERE s.religion = :religion"),
		@NamedQuery(name = "Student.findByDateOfBirth", query = "SELECT s FROM Student s WHERE s.dateOfBirth = :dateOfBirth"),
		@NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = :gender") })
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "student_id")
	private Long studentId;
	@Basic(optional = false)
	@Column(name = "registration_no")
	private int registrationNo;
	@Basic(optional = false)
	@Column(name = "email_no")
	private String emailNo;
	@Basic(optional = false)
	@Column(name = "contact_no")
	private String contactNo;
	@Column(name = "Address")
	private String address;
	@Basic(optional = false)
	@Column(name = "first_name")
	private String firstName;
	@Basic(optional = false)
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "marital_status")
	private String maritalStatus;
	@Column(name = "blood_group")
	private String bloodGroup;
	@Column(name = "religion")
	private String religion;
	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Basic(optional = false)
	@Column(name = "gender")
	private String gender;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
	private List<CourseReg> courseRegList;
	@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
	@ManyToOne(optional = false)
	private Department deptId;

	public Student() {
	}

	public Student(Long studentId) {
		this.studentId = studentId;
	}

	public Student(Long studentId, int registrationNo, String emailNo, String contactNo, String firstName,
			String lastName, String gender) {
		this.studentId = studentId;
		this.registrationNo = registrationNo;
		this.emailNo = emailNo;
		this.contactNo = contactNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public int getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(int registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getEmailNo() {
		return emailNo;
	}

	public void setEmailNo(String emailNo) {
		this.emailNo = emailNo;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@XmlTransient
	public List<CourseReg> getCourseRegList() {
		return courseRegList;
	}

	public void setCourseRegList(List<CourseReg> courseRegList) {
		this.courseRegList = courseRegList;
	}

	public Department getDeptId() {
		return deptId;
	}

	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (studentId != null ? studentId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Student)) {
			return false;
		}
		Student other = (Student) object;
		if ((this.studentId == null && other.studentId != null)
				|| (this.studentId != null && !this.studentId.equals(other.studentId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.great.cms.db.entity.Student[ studentId=" + studentId + " ]";
	}

}
