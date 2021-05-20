package br.edu.vaccineapp.endpoint.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/vaccine", produces = MediaType.APPLICATION_JSON_VALUE)
public class VaccineController {



}
