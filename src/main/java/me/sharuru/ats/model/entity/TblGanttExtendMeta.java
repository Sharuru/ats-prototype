package me.sharuru.ats.model.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TblGanttExtendMeta {

    private Long id;

    private Long taskId;

    private BigDecimal taskLvl;

}
