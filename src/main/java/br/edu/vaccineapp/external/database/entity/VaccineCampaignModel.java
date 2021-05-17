package br.edu.vaccineapp.external.database.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema ="vaccine", name = "VACCINE_CAMPAIGN")
public class VaccineCampaignModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VACCINEORG.VACCINECAMPAIGN_SEQ")
    @SequenceGenerator(sequenceName = "VACCINEORG.VACCINECAMPAIGN_SEQ", allocationSize = 1, name = "VACCINEORG.VACCINECAMPAIGN_SEQ")
    @Column(name = "vaccine_campaign_id_pk")
    private Long id;

    @Column(name = "number_vaccines")
    private Long numberVaccines;

    @ManyToOne
    @MapsId("campaignId")
    @JoinColumn(name = "campaign_id_pk")
    private CampaignModel campaign;

    @ManyToOne
    @MapsId("vaccineId")
    @JoinColumn(name = "vaccine_id_pk")
    private VaccineModel vaccine;

    @Column(name="date_create")
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

    public CampaignModel getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignModel campaign) {
        this.campaign = campaign;
    }

    public VaccineModel getVaccine() {
        return vaccine;
    }

    public void setVaccine(VaccineModel vaccine) {
        this.vaccine = vaccine;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
