/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computer.career_service.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lenny
 */
@Entity
@Table(name = "roles_offered", catalog = "career_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolesOffered.findAll", query = "SELECT r FROM RolesOffered r")
    , @NamedQuery(name = "RolesOffered.findById", query = "SELECT r FROM RolesOffered r WHERE r.id = :id")
    , @NamedQuery(name = "RolesOffered.findByStatus", query = "SELECT r FROM RolesOffered r WHERE r.status = :status")})
public class RolesOffered implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status", nullable = false)
    private int status;
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Offer roleId;
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Student studentId;

    public RolesOffered() {
    }

    public RolesOffered(Integer id) {
        this.id = id;
    }

    public RolesOffered(Integer id, int status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Offer getRoleId() {
        return roleId;
    }

    public void setRoleId(Offer roleId) {
        this.roleId = roleId;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesOffered)) {
            return false;
        }
        RolesOffered other = (RolesOffered) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.computer.career_service.entities.RolesOffered[ id=" + id + " ]";
    }
    
}
