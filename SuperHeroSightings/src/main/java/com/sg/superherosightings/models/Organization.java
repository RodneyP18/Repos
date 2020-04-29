/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.models;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 *
 * @author Buddy
 */
@Entity
@Table (name = "organizations")
public class Organization {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int orgId;
    
    @Column(nullable = false)
    @NotBlank(message = "Organization name must not be empty.")
    private String orgName;
    
    @Column(nullable = false)
    @NotBlank(message = "Description must not be empty.")
    private String orgDesc;
    
    @Column(nullable = false)
    @NotBlank(message = "Address must not be empty.")
    private String address;
    
    @Column(nullable = false)
    @NotBlank(message = "Phone number must not be empty.")
    private String phone;
    
    @Column(nullable = false)
    @NotBlank(message = "Email must not be empty.")
    private String email;
    
    @ManyToMany
    @JoinTable(name = "heroOrg",
    joinColumns = {@JoinColumn(name = "orgId")},
    inverseJoinColumns = {@JoinColumn(name = "heroId")})
    @NotNull(message = "Must add heroes.")
    private List<Hero> members;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.orgId;
        hash = 17 * hash + Objects.hashCode(this.orgName);
        hash = 17 * hash + Objects.hashCode(this.orgDesc);
        hash = 17 * hash + Objects.hashCode(this.address);
        hash = 17 * hash + Objects.hashCode(this.phone);
        hash = 17 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Organization other = (Organization) obj;
        if (this.orgId != other.orgId) {
            return false;
        }
        if (!Objects.equals(this.orgName, other.orgName)) {
            return false;
        }
        if (!Objects.equals(this.orgDesc, other.orgDesc)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

   
    
    /**
     * @return the orgId
     */
    public int getOrgId() {
        return orgId;
    }

    /**
     * @param orgId the orgId to set
     */
    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    /**
     * @return the orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return the orgDesc
     */
    public String getOrgDesc() {
        return orgDesc;
    }

    /**
     * @param orgDesc the orgDesc to set
     */
    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the members
     */
    public List<Hero> getMembers() {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers(List<Hero> members) {
        this.members = members;
    }
    
   
    
}
