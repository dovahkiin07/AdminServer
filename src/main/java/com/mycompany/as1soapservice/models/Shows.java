/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.as1soapservice.models;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adityatuli
 */
@Entity
@Table(name = "SHOWS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shows.findAll", query = "SELECT s FROM Shows s"),
    @NamedQuery(name = "Shows.findById", query = "SELECT s FROM Shows s WHERE s.id = :id"),
    @NamedQuery(name = "Shows.findByTitle", query = "SELECT s FROM Shows s WHERE s.title = :title"),
    @NamedQuery(name = "Shows.findByDescription", query = "SELECT s FROM Shows s WHERE s.description = :description"),
    @NamedQuery(name = "Shows.findByRating", query = "SELECT s FROM Shows s WHERE s.rating = :rating"),
    @NamedQuery(name = "Shows.findByDirector", query = "SELECT s FROM Shows s WHERE s.director = :director"),
    @NamedQuery(name = "Shows.findByCategory", query = "SELECT s FROM Shows s WHERE s.category = :category"),
    @NamedQuery(name = "Shows.findByType", query = "SELECT s FROM Shows s WHERE s.type = :type")})
public class Shows implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "RATING")
    private String rating;
    @Size(max = 50)
    @Column(name = "DIRECTOR")
    private String director;
    @Size(max = 50)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "TYPE")
    private String type;
    @Lob
    @Column(name = "THUMBNAIL")
    private byte[] thumbnail;

    public Shows() {
    }

    public Shows(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
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
        if (!(object instanceof Shows)) {
            return false;
        }
        Shows other = (Shows) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.as1soapservice.models.Shows[ id=" + id + " ]";
    }
    
}
