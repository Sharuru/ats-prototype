package me.sharuru.ats.web;

import lombok.extern.slf4j.Slf4j;
import me.sharuru.ats.model.response.GanttTasksResponse;
import me.sharuru.ats.service.GanttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    GanttService ganttService;

    @ResponseBody
    @GetMapping("/loadGanttTasks")
    public GanttTasksResponse loadTasks() {
        return ganttService.loadGanttTasks();
    }
}
