package br.edu.vaccineapp.external.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "VACCINEORG", name = "USERS")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VACCINEORG.USERS_SEQ")
    @SequenceGenerator(sequenceName = "VACCINEORG.USERS_SEQ", allocationSize = 1, name = "VACCINEORG.USERS_SEQ")
    @Column(name = "user_id_pk")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "date_create")
    private Date dateCreate;

    @OneToMany(mappedBy = "user")
    private List<UserVaccineCampaignModel> userCampaigns;

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

    public List<UserVaccineCampaignModel> getUserCampaigns() {
        return userCampaigns;
    }

    public void setUserCampaigns(List<UserVaccineCampaignModel> userCampaigns) {
        this.userCampaigns = userCampaigns;
    }
}
