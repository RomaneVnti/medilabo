package com.openclassrooms.risk.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Proxy Feign pour communiquer avec le microservice Notes.
 */
@FeignClient(name = "notes", url = "http://notes:9101")
public interface NoteProxy {

    /**
     * Récupère la liste des notes associées à un patient donné.
     *
     * @param patId l'identifiant du patient
     * @return une liste de notes sous forme de chaînes de caractères
     */
    @GetMapping(value = "/notes/{patId}")
    List<String> listDesNotes(@PathVariable Integer patId);
}
