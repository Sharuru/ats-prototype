package me.sharuru.ats.model.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.sharuru.ats.model.entity.TblGanttTasks;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class GanttTasksWithExtendMetaPo extends TblGanttTasks {

    private BigDecimal taskRank;
}
