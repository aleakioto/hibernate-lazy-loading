package com.persistance;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable
{
    private int recId;
    private String name;
    private String department;
    private String comment;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Column
    @Basic(fetch=FetchType.LAZY)
    @Lob
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Transient
    @Override
    public String toString() {
        return "Customer {" +
                "id=" + recId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", comment='" + comment + '\'';

    }
}
