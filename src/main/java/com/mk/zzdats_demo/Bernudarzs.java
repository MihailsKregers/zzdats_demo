package com.mk.zzdats_demo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
public class Bernudarzs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "aiznemtaRinda", fetch = FetchType.EAGER)
    private List<Berns> rinda = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Berns> getRinda() {
        return rinda;
    }

}
