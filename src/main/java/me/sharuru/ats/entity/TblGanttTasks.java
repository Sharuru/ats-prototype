package me.sharuru.ats.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "t_gantt_tasks")
public class TblGanttTasks {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "t_gantt_tasks_id_seq")
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "text")
    private String text;

    @Column(name = "progress")
    private BigDecimal progress;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "sortorder")
    private Long sortOrder;

    @Column(name = "parent")
    private Long parent;

    @OneToOne(mappedBy="task")
    private TblGanttExtendMetas extendMetas;

    public TblGanttTasks() {
    }
}
