package com.coma.Entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Units
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int unitId;
    private String unitName;
    private String shortForm;
    private String description;
  

    public Units() {
    }

    @Override
    public String toString() {
        return "{" +
            " unitId='" + getUnitId() + "'" +
            ", unitName='" + getUnitName() + "'" +
            ", shortForm='" + getShortForm() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }



    public Units(int unitId, String unitName, String shortForm, String description) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.shortForm = shortForm;
        this.description = description;
    }


    public int getUnitId() {
        return this.unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return this.unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getShortForm() {
        return this.shortForm;
    }

    public void setShortForm(String shortForm) {
        this.shortForm = shortForm;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
