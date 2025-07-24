package com.openclassrooms.risk.proxies;

import com.openclassrooms.risk.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "patient", url = "http://localhost:8081")
public interface PatientProxy {

    @GetMapping (value = "/patients")
    List<PatientBean> listDesPatients();

    @GetMapping(value = "/patients/{patId}")
    PatientBean getOnePatient(@PathVariable Integer patId);

}