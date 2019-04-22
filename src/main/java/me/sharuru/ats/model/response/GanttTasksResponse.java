package me.sharuru.ats.model.response;

import lombok.Data;
import me.sharuru.ats.entity.TblGanttExtendMetas;
import me.sharuru.ats.entity.TblGanttLinks;
import me.sharuru.ats.entity.TblGanttTasks;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class GanttTasksResponse {

    private List<Task> data = new ArrayList<>(0);

    private List<Links> links = new ArrayList<>(0);

    public void appendNewTask(TblGanttTasks aTask) {
        Task newTask = new Task();
        newTask.setId(aTask.getId());
        newTask.setText(aTask.getText());
        newTask.setStart_date(aTask.getStartDate().format(DateTimeFormatter.ISO_DATE));
        newTask.setDuration(aTask.getDuration());
        newTask.setParent(aTask.getParent());
        ExtendMeta aMeta = new ExtendMeta();
        aMeta.setTaskRank(
                Optional.of(aTask)
                        .map(TblGanttTasks::getExtendMetas)
                        .map(TblGanttExtendMetas::getTaskRank)
                        .orElse(BigDecimal.ZERO)
        );
        newTask.setExtendMeta(aMeta);
        this.data.add(newTask);
    }

    public void appendNewLink(TblGanttLinks aLink) {
        Links newLink = new Links();
        newLink.setId(aLink.getId());
        newLink.setSource(aLink.getSource());
        newLink.setTarget(aLink.getTarget());
        newLink.setType(aLink.getType());
        this.links.add(newLink);
    }
}

@Data
class Task {
    private Long id;
    private String text;
    private String start_date;
    private Long duration;
    private Long parent;
    private ExtendMeta extendMeta;
}

@Data
class Links {
    private Long id;
    private Long source;
    private Long target;
    private String type;
}

@Data
class ExtendMeta {
    private BigDecimal taskRank;
}