package br.edu.vaccineapp.endpoint.rest;

import br.edu.vaccineapp.entity.Vaccine;
import br.edu.vaccineapp.usecase.read.GetAllVaccines;
import br.edu.vaccineapp.viewmodel.VaccineVM;
import br.edu.vaccineapp.viewmodel.adapter.VaccineVMAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/vaccine", produces = MediaType.APPLICATION_JSON_VALUE)
public class VaccineController {

    @Autowired
    private GetAllVaccines getAllVaccines;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<VaccineVM>> getAllVaccines(@RequestHeader("user-profile") final String userProfile) {
        try {
            final List<Vaccine> vaccineList = getAllVaccines.execute(userProfile);
            final List<VaccineVM> vaccineVMList = new ArrayList<>();

            for (Vaccine item : vaccineList) {
                vaccineVMList.add(VaccineVMAdapter.entityToViewModel(item));
            }

            return ResponseEntity.status(HttpStatus.OK).body(vaccineVMList);
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

}
