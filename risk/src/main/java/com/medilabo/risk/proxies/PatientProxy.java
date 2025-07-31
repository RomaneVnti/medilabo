package com.openclassrooms.risk.proxies;

import com.openclassrooms.risk.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "patient", url = "http://patient:8081")
public interface PatientProxy {

    @GetMapping (value = "/api/patients")
    List<PatientBean> listDesPatients();

    @GetMapping(value = "/api/patients/{patId}")
    PatientBean getOnePatient(@PathVariable Integer patId);

}