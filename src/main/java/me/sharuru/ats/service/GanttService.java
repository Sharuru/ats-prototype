package me.sharuru.ats.service;

import lombok.extern.slf4j.Slf4j;
import me.sharuru.ats.model.entity.TblGanttLinks;
import me.sharuru.ats.model.entity.TblGanttTasks;
import me.sharuru.ats.mapper.GanttLinksMapper;
import me.sharuru.ats.mapper.GanttTasksMapper;
import me.sharuru.ats.model.po.GanttTasksWithExtendMetaPo;
import me.sharuru.ats.model.response.GanttGraphResponse;
import me.sharuru.ats.model.response.GanttLinksResponse;
import me.sharuru.ats.model.response.GanttTasksResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class GanttService {

    @Resource
    private GanttTasksMapper ganttTasksMapper;

    @Resource
    private GanttLinksMapper ganttLinksMapper;

    public GanttGraphResponse loadGanttTasks() {
        GanttGraphResponse response = new GanttGraphResponse();
        List<GanttTasksWithExtendMetaPo> queriedTasks = ganttTasksMapper.findAll();
        // TODO cleanup
        for (GanttTasksWithExtendMetaPo aTask : queriedTasks) {
            GanttTasksResponse task = new GanttTasksResponse();
            task.setId(aTask.getId());
            task.setText(aTask.getText());
            task.setStart_date(aTask.getStartDate().format(DateTimeFormatter.ISO_DATE));
            task.setDuration(aTask.getDuration());
            task.setParent(aTask.getParent());
            log.info(String.valueOf(task.getExt_task_rank()));
            task.setExt_task_rank(aTask.getTaskRank());
            response.getData().add(task);
        }
        List<TblGanttLinks> queriedLinks = ganttLinksMapper.findAll();
        // TODO cleanup
        for (TblGanttLinks aLink : queriedLinks) {
            GanttLinksResponse link = new GanttLinksResponse();
            link.setId(aLink.getId());
            link.setSource(aLink.getSource());
            link.setTarget(aLink.getTarget());
            link.setType(aLink.getType());
            response.getLinks().add(link);
        }
        return response;
    }
}
