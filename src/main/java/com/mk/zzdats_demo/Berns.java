package com.mk.zzdats_demo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Berns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Vārds ir obligāts")
    private String fName;

    @NotBlank(message = "Uzvārds ir obligāts")
    private String lName;

    @Pattern(regexp = "^[0-9]{6}[-][0-9]{5}$", message="Jāatbilst formātam xxxxxx-xxxxx (x vietās cipari)")
    private String persCode;

    @NotNull
    private Date date = new Date();

    @NotNull
    private boolean brOrSist;

    @ManyToOne
    @JoinColumn(name="rinda")
    private Bernudarzs aiznemtaRinda;

    public Long getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPersCode() {
        return persCode;
    }

    public void setPersCode(String persCode) {
        this.persCode = persCode;
    }

    public boolean getBrOrSist() {
        return brOrSist;
    }

    public void setBrOrSist(boolean brOrSist) {
        this.brOrSist = brOrSist;
    }

    public Date getDate() {
        return date;
    }

    public Bernudarzs getAiznemtaRinda() {
        return aiznemtaRinda;
    }

    public void setAiznemtaRinda(Bernudarzs aiznemtaRinda) {
        this.aiznemtaRinda = aiznemtaRinda;
    }
}
