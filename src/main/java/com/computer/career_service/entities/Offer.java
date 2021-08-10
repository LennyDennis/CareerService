/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computer.career_service.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lenny
 */
@Entity
@Table(name = "offer", catalog = "career_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o")
    , @NamedQuery(name = "Offer.findById", query = "SELECT o FROM Offer o WHERE o.id = :id")
    , @NamedQuery(name = "Offer.findByOfferType", query = "SELECT o FROM Offer o WHERE o.offerType = :offerType")
    , @NamedQuery(name = "Offer.findByNumberRequired", query = "SELECT o FROM Offer o WHERE o.numberRequired = :numberRequired")
    , @NamedQuery(name = "Offer.findByApplicationDate", query = "SELECT o FROM Offer o WHERE o.applicationDate = :applicationDate")
    , @NamedQuery(name = "Offer.findByStartDate", query = "SELECT o FROM Offer o WHERE o.startDate = :startDate")
    , @NamedQuery(name = "Offer.findByEndDate", query = "SELECT o FROM Offer o WHERE o.endDate = :endDate")})
public class Offer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description", nullable = false, length = 65535)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "offer_type", nullable = false)
    private int offerType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number_required", nullable = false)
    private int numberRequired;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "place_of_work", nullable = false, length = 65535)
    private String placeOfWork;
    @Basic(optional = false)
    @NotNull
    @Column(name = "application_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date applicationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Company companyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offerId")
    private List<Skill> skillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private List<RolesOffered> rolesOfferedList;

    public Offer() {
    }

    public Offer(Integer id) {
        this.id = id;
    }

    public Offer(Integer id, String description, int offerType, int numberRequired, String placeOfWork, Date applicationDate, Date startDate, Date endDate) {
        this.id = id;
        this.description = description;
        this.offerType = offerType;
        this.numberRequired = numberRequired;
        this.placeOfWork = placeOfWork;
        this.applicationDate = applicationDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOfferType() {
        return offerType;
    }

    public void setOfferType(int offerType) {
        this.offerType = offerType;
    }

    public int getNumberRequired() {
        return numberRequired;
    }

    public void setNumberRequired(int numberRequired) {
        this.numberRequired = numberRequired;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    @XmlTransient
    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @XmlTransient
    public List<RolesOffered> getRolesOfferedList() {
        return rolesOfferedList;
    }

    public void setRolesOfferedList(List<RolesOffered> rolesOfferedList) {
        this.rolesOfferedList = rolesOfferedList;
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
        if (!(object instanceof Offer)) {
            return false;
        }
        Offer other = (Offer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.computer.career_service.entities.Offer[ id=" + id + " ]";
    }
    
}
