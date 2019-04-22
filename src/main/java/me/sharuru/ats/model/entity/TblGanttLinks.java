package me.sharuru.ats.model.entity;

import lombok.Data;

@Data
public class TblGanttLinks {

    private Long id;

    private Long source;

    private Long target;

    private String type;
}