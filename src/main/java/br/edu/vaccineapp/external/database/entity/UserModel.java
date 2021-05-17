package br.edu.vaccineapp.external.database.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "VACCINEMODEL", name = "USERS")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VACCINEORG.USERS_SEQ")
    @SequenceGenerator(sequenceName = "VACCINEORG.USERS_SEQ", allocationSize = 1, name = "VACCINEORG.USERS_SEQ")
    @Column(name = "user_id_pk")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "date_create")
    private Date date_create;

    @OneToMany(mappedBy = "user")
    private List<UserVaccineCampaignModel> userCampaigns;

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

    public List<UserVaccineCampaignModel> getUserCampaigns() {
        return userCampaigns;
    }

    public void setUserCampaigns(List<UserVaccineCampaignModel> userCampaigns) {
        this.userCampaigns = userCampaigns;
    }
}
