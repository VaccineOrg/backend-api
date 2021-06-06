package br.edu.vaccineapp.endpoint.rest;

import br.edu.vaccineapp.entity.User;
import br.edu.vaccineapp.entity.UserCampaign;
import br.edu.vaccineapp.external.database.GetUserByIdInDataBaseImpl;
import br.edu.vaccineapp.usecase.read.GetUserByName;
import br.edu.vaccineapp.usecase.read.GetUserCampaigns;
import br.edu.vaccineapp.viewmodel.UserCampaignsVM;
import br.edu.vaccineapp.viewmodel.adapter.UserCampaignsVMAdapter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/vaccination", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserCampaignsController {

    @Autowired
    private GetUserByName getUserByName;

    @Autowired
    private GetUserCampaigns getUserCampaigns;

    @Autowired
    private GetUserByIdInDataBaseImpl getUserByIdInDataBase;

    @GetMapping("/{id}/campaigns")
    @ApiOperation(value = "Return all user's campaigns")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getUserCampaignsByUserName(@PathVariable final Long id){
        try{
            final User user = getUserByIdInDataBase.execute(id);
            final List<UserCampaign> userCampaignList = getUserCampaigns.execute(user);
            Collections.sort(userCampaignList, Comparator.comparing(UserCampaign::getDateCreate).reversed());
            UserCampaignsVM userCampaignsVM = new UserCampaignsVM();
            userCampaignsVM.setUserCampaigns(UserCampaignsVMAdapter.entityToViewModel(user, userCampaignList));
            return ResponseEntity.ok().body(userCampaignsVM);
        }catch(Exception err) {
            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }
}
