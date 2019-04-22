package me.sharuru.ats.model.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GanttTasksResponse {

    private Long id;
    private String text;
    private String start_date;
    private Long duration;
    private Long parent;
    private BigDecimal ext_task_rank;

}
