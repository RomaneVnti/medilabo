package com.openclassrooms.risk.beans;

import lombok.Data;

@Data
public class NoteBean {

    private Integer patId;
    private String patient;
    private String note;
}