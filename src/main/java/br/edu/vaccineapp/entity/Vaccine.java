package br.edu.vaccineapp.entity;

import java.util.Date;
import java.util.List;

public class Vaccine {

    private Long id;
    private String name;
    private String description;
    private Date dateCreate;
    private List<UserVaccineCampaign> userCampaigns;
    private List<VaccineCampaign> vaccineCampaigns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<UserVaccineCampaign> getUserCampaigns() {
        return userCampaigns;
    }

    public void setUserCampaigns(List<UserVaccineCampaign> userCampaigns) {
        this.userCampaigns = userCampaigns;
    }

    public List<VaccineCampaign> getVaccineCampaigns() {
        return vaccineCampaigns;
    }

    public void setVaccineCampaigns(List<VaccineCampaign> vaccineCampaigns) {
        this.vaccineCampaigns = vaccineCampaigns;
    }
}
