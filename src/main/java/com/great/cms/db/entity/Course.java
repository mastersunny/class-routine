/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.great.cms.db.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.stereotype.Component;

/**
 *
 * @author sss
 */
@Component
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseId", query = "SELECT c FROM Course c WHERE c.courseId = :courseId"),
    @NamedQuery(name = "Course.findByCourseCode", query = "SELECT c FROM Course c WHERE c.courseCode = :courseCode"),
    @NamedQuery(name = "Course.findByCourseTitle", query = "SELECT c FROM Course c WHERE c.courseTitle = :courseTitle"),
    @NamedQuery(name = "Course.findBySemester", query = "SELECT c FROM Course c WHERE c.semester = :semester"),
    @NamedQuery(name = "Course.findBySession", query = "SELECT c FROM Course c WHERE c.session = :session"),
    @NamedQuery(name = "Course.findByOfferingDept", query = "SELECT c FROM Course c WHERE c.offeringDept = :offeringDept"),
    @NamedQuery(name = "Course.findByAcceptingDept", query = "SELECT c FROM Course c WHERE c.acceptingDept = :acceptingDept"),
    @NamedQuery(name = "Course.findByCredit", query = "SELECT c FROM Course c WHERE c.credit = :credit")})
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "course_id")
    private Integer courseId;
    @Basic(optional = false)
    @Column(name = "course_code")
    private String courseCode;
    @Basic(optional = false)
    @Column(name = "course_title")
    private String courseTitle;
    @Basic(optional = false)
    @Column(name = "semester")
    private int semester;
    @Basic(optional = false)
    @Column(name = "session")
    private int session;
    @Basic(optional = false)
    @Column(name="hour")
    private int hour;
    @Basic(optional = false)
    @Column(name = "offering_dept")
    private String offeringDept;
    @Basic(optional = false)
    @Column(name = "accepting_dept")
    private String acceptingDept;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "credit")
    private BigDecimal credit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private List<CourseReg> courseRegList;
    @JoinColumn(name = "general_type_id", referencedColumnName = "general_type_id")
    @ManyToOne(optional = false)
    private GeneralType generalTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private List<Teaches> teachesList;

    public Course() {
    }

    public Course(Integer courseId) {
        this.courseId = courseId;
    }

    public Course(Integer courseId, String courseCode, String courseTitle, int semester, int session,int hour, String offeringDept, String acceptingDept, BigDecimal credit) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.semester = semester;
        this.session = session;
        this.offeringDept = offeringDept;
        this.acceptingDept = acceptingDept;
        this.credit = credit;
        this.hour = hour;
    }

    
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getSession() {
        return session;
    }
    
    public void setSession(int session) {
        this.session = session;
    }
    
    public void setHour(int hour) {
    	this.hour = hour;
    }
    
    public int getHour() {
    	return hour;
    }

    

    public String getOfferingDept() {
        return offeringDept;
    }

    public void setOfferingDept(String offeringDept) {
        this.offeringDept = offeringDept;
    }

    public String getAcceptingDept() {
        return acceptingDept;
    }

    public void setAcceptingDept(String acceptingDept) {
        this.acceptingDept = acceptingDept;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    @XmlTransient
    public List<CourseReg> getCourseRegList() {
        return courseRegList;
    }

    public void setCourseRegList(List<CourseReg> courseRegList) {
        this.courseRegList = courseRegList;
    }

    public GeneralType getGeneralTypeId() {
        return generalTypeId;
    }

    public void setGeneralTypeId(GeneralType generalTypeId) {
        this.generalTypeId = generalTypeId;
    }

    @XmlTransient
    public List<Teaches> getTeachesList() {
        return teachesList;
    }

    public void setTeachesList(List<Teaches> teachesList) {
        this.teachesList = teachesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseCode=" + courseCode
				+ ", courseTitle=" + courseTitle + "]";
	}

   
    
}
