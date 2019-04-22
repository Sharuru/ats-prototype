package me.sharuru.ats.mapper;

import me.sharuru.ats.model.entity.TblGanttLinks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GanttLinksMapper {

    @Select("SELECT * FROM t_gantt_links")
    List<TblGanttLinks> findAll();
}
