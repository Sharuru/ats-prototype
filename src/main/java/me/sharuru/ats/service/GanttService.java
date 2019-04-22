package me.sharuru.ats.service;

import lombok.extern.slf4j.Slf4j;
import me.sharuru.ats.entity.TblGanttLinks;
import me.sharuru.ats.entity.TblGanttTasks;
import me.sharuru.ats.model.response.GanttTasksResponse;
import me.sharuru.ats.repository.GanttLinksRepository;
import me.sharuru.ats.repository.GanttTasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GanttService {

    @Autowired
    GanttTasksRepository ganttTasksRepository;

    @Autowired
    GanttLinksRepository ganttLinksRepository;

    public GanttTasksResponse loadGanttTasks() {
        GanttTasksResponse response = new GanttTasksResponse();
        List<TblGanttTasks> queriedTasks = ganttTasksRepository.findAll(Sort.by("id").ascending());
        for (TblGanttTasks aTask : queriedTasks) {
            response.appendNewTask(aTask);
        }
        List<TblGanttLinks> queriedLinks = ganttLinksRepository.findAll();
        for (TblGanttLinks aLink : queriedLinks) {
            response.appendNewLink(aLink);
        }
        return response;
    }
}
