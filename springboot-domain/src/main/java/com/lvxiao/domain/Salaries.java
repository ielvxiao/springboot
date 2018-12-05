package com.lvxiao.domain;


import java.io.Serializable;

public class Salaries implements Serializable {

    private static final long serialVersionUID = 302066778546343045L;
    private long empNo;
    private long salary;
    private java.sql.Date fromDate;
    private java.sql.Date toDate;


    public long getEmpNo() {
        return empNo;
    }

    public void setEmpNo(long empNo) {
        this.empNo = empNo;
    }


    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }


    public java.sql.Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(java.sql.Date fromDate) {
        this.fromDate = fromDate;
    }


    public java.sql.Date getToDate() {
        return toDate;
    }

    public void setToDate(java.sql.Date toDate) {
        this.toDate = toDate;
    }

}
