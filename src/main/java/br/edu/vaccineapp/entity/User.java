package br.edu.vaccineapp.entity;

import java.util.Date;
import java.util.List;

public class User {

    private Long id;
    private String name;
    private String employeeId;
    private Date date_create;
    private List<UserVaccineCampaign> userCampaigns;

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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }

    public List<UserVaccineCampaign> getUserCampaigns() {
        return userCampaigns;
    }

    public void setUserCampaigns(List<UserVaccineCampaign> userCampaigns) {
        this.userCampaigns = userCampaigns;
    }
}
