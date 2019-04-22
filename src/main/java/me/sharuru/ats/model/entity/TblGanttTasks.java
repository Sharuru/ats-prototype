package me.sharuru.ats.model.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TblGanttTasks {

    private Long id;

    private LocalDate startDate;

    private String text;

    private BigDecimal progress;

    private Long duration;

    private Long sortOrder;

    private Long parent;
}
