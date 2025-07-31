package com.openclassrooms.risk.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "notes", url = "http://notes:9101")
public interface NoteProxy {

    @GetMapping(value = "/notes/{patId}")
    List<String> listDesNotes(@PathVariable Integer patId);
}