package me.sharuru.ats.mapper;

import me.sharuru.ats.model.po.GanttTasksWithExtendMetaPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GanttTasksMapper {

    @Select("SELECT * FROM t_gantt_tasks AS GT LEFT JOIN t_gantt_extend_meta AS GEM ON GT.id = GEM.task_id ORDER BY GT.id ASC")

    List<GanttTasksWithExtendMetaPo> findAll();
}
