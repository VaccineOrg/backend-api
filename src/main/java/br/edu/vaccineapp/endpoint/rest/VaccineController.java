package br.edu.vaccineapp.endpoint.rest;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.usecase.creation.CreateVaccine;
import br.edu.vaccineapp.usecase.delete.DeleteVaccine;
import br.edu.vaccineapp.usecase.read.GetAllVaccines;
import br.edu.vaccineapp.usecase.read.GetVaccineById;
import br.edu.vaccineapp.usecase.update.UpdateVaccine;
import br.edu.vaccineapp.viewmodel.VaccineVM;
import br.edu.vaccineapp.viewmodel.adapter.VaccineVMAdapter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/vaccine", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Vaccine Application API")
@CrossOrigin(origins = "http://localhost:3000")
public class VaccineController {

    @Autowired
    private GetAllVaccines getAllVaccines;

    @Autowired
    private CreateVaccine createVaccine;

    @Autowired
    private GetVaccineById getVaccineById;

    @Autowired
    private UpdateVaccine updateVaccine;

    @Autowired
    private DeleteVaccine deleteVaccine;

    @GetMapping
    @ApiOperation(value = "Return all vaccines in data base")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<VaccineVM>> getAllVaccines(@RequestHeader("user-profile") final String userProfile) {
        try {
            final List<Vaccine> vaccineList = getAllVaccines.execute(userProfile);
            final List<VaccineVM> vaccineVMList = new ArrayList<>();
            for (Vaccine item : vaccineList) {
                vaccineVMList.add(VaccineVMAdapter.entityToViewModel(item));
            }
            return ResponseEntity.status(HttpStatus.OK).body(vaccineVMList);
        }catch (Exception err) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @PostMapping
    @ApiOperation(value = "Create vaccine in data base")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VaccineVM> createVaccine (@RequestHeader("user-profile") final String userProfile, @RequestBody final VaccineVM vaccineVM) {
        try{
            final Vaccine vaccine = createVaccine.execute(VaccineVMAdapter.viewModelToEntity(vaccineVM), userProfile);
            final VaccineVM result = VaccineVMAdapter.entityToViewModel(vaccine);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception err){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(vaccineVM);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update vaccine in data base")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VaccineVM> updateVaccine(@RequestHeader("user-profile") final String userProfile, @RequestBody final VaccineVM vaccineVM, @PathVariable final Long id){
        try{
            final Vaccine vaccine = getVaccineById.execute(id);
            vaccine.setName(vaccineVM.getName());
            vaccine.setDescription(vaccineVM.getDescription());

            final Vaccine vaccineAux = updateVaccine.execute(vaccine, userProfile);
            final VaccineVM result = VaccineVMAdapter.entityToViewModel(vaccineAux);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(vaccineVM);
        }
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete vaccine in data base")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteVaccineById(@RequestHeader("user-profile") final String userProfile, @PathVariable final Long id) {
        try {
            final Vaccine vaccine = getVaccineById.execute(id);
            final boolean result = deleteVaccine.execute(vaccine, userProfile);
            if(result) return ResponseEntity.status(HttpStatus.OK).body(null);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

}
