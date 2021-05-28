package br.edu.vaccineapp.endpoint.rest;

import br.edu.vaccineapp.entity.Campaign;
import br.edu.vaccineapp.usecase.creation.CreateCampaign;
import br.edu.vaccineapp.viewmodel.CampaignVM;
import br.edu.vaccineapp.viewmodel.adapter.CampaignVMAdapter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/v1/campaigns", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampaignsController {

    @Autowired
    private CreateCampaign createCampaign;

    @PostMapping
    @ApiOperation(value = "Create campaign in data base")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CampaignVM> createCampaign(@RequestHeader("user-profile") final String userProfile, @RequestBody final CampaignVM campaignVM) throws ParseException {
        final Campaign campaign = createCampaign.execute(userProfile, CampaignVMAdapter.viewModelToEntity(campaignVM));
        final CampaignVM result = CampaignVMAdapter.entityToViewModel(campaign);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
