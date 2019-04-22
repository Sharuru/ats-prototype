package me.sharuru.ats.model.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GanttGraphResponse {

    private List<GanttTasksResponse> data = new ArrayList<>(0);

    private List<GanttLinksResponse> links = new ArrayList<>(0);

}
