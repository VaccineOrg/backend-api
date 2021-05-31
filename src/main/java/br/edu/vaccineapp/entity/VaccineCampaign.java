package br.edu.vaccineapp.entity;

import java.util.Date;

public class VaccineCampaign {

    private Long id;
    private Long numberVaccines;
    private Campaign campaign;
    private Vaccine vaccine;
    private Date dateCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberVaccines() {
        return numberVaccines;
    }

    public void setNumberVaccines(Long numberVaccines) {
        this.numberVaccines = numberVaccines;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
