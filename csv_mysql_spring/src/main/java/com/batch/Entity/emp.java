package com.batch.Entity;

public class emp {
    private String organisation_id;
    private String name;
    private String website;
    private String country;
    private Integer founded_date;
    private Integer no_of_emp;

    public emp(String organisation_id, String name, String website, String country, Integer founded_date, Integer no_of_emp) {
        this.organisation_id = organisation_id;
        this.name = name;
        this.website = website;
        this.country = country;
        this.founded_date = founded_date;
        this.no_of_emp = no_of_emp;
    }

    public emp() {
        super();
    }

    public String getOrganisation_id() {
        return organisation_id;
    }

    public void setOrganisation_id(String organisation_id) {
        this.organisation_id = organisation_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getFounded_date() {
        return founded_date;
    }

    public void setFounded_date(Integer founded_date) {
        this.founded_date = founded_date;
    }

    public Integer getNo_of_emp() {
        return no_of_emp;
    }

    public void setNo_of_emp(Integer no_of_emp) {
        this.no_of_emp = no_of_emp;
    }
}
