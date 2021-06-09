package br.edu.vaccineapp.endpoint.rest;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.external.database.GetCampaignByIdInDataBaseImpl;
import br.edu.vaccineapp.external.database.GetUserByIdInDataBaseImpl;
import br.edu.vaccineapp.usecase.creation.CreateUserVaccineCampaign;
import br.edu.vaccineapp.usecase.read.GetVaccineById;
import br.edu.vaccineapp.viewmodel.input.UserVaccinCampaignVM;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/userVaccineCampaign", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserVaccineCampaignController {

    @Autowired
    private GetCampaignByIdInDataBaseImpl getCampaignByIdInDataBase;

    @Autowired
    private GetVaccineById getVaccineById;

    @Autowired
    private GetUserByIdInDataBaseImpl getUserByIdInDataBase;

    @Autowired
    private CreateUserVaccineCampaign createUserVaccineCampaign;

    @PostMapping("/accenssion/{idCampaign}")
    @ApiOperation(value = "Create de accenssion in database")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity campaignAccession(@PathVariable Long idCampaign, @RequestBody UserVaccinCampaignVM userVaccinCampaignVM) {
        User user = getUserByIdInDataBase.execute(userVaccinCampaignVM.getIdUser());
        Vaccine vaccine = getVaccineById.execute(userVaccinCampaignVM.getIdVaccine());
        Campaign campaign = getCampaignByIdInDataBase.execute(idCampaign);
        createUserVaccineCampaign.execute(user, campaign, vaccine);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
