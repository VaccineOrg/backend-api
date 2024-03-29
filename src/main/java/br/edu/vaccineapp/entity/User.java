package br.edu.vaccineapp.entity;

import java.util.Date;
import java.util.List;

public class User {

    private Long id;
    private String userName;
    private String email;
    private String password;
    private String employeeId;
    private Date dateCreate;
    private List<UserCampaign> userCampaigns;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public List<UserCampaign> getUserCampaigns() {
        return userCampaigns;
    }

    public void setUserCampaigns(List<UserCampaign> userCampaigns) {
        this.userCampaigns = userCampaigns;
    }
}
