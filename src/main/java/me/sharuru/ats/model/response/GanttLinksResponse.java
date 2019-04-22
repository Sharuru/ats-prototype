package me.sharuru.ats.model.response;

import lombok.Data;

@Data
public class GanttLinksResponse {
    private Long id;
    private Long source;
    private Long target;
    private String type;
}
