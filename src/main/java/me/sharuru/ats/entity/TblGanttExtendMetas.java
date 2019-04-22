package me.sharuru.ats.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "t_gantt_extend_metas")
public class TblGanttExtendMetas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "t_gantt_extend_metas_id_seq")
    private Long id;

    @OneToOne
    @JoinColumn(name = "task_id")
    private TblGanttTasks task;

    @Column(name = "task_rank")
    private BigDecimal taskRank;

    public TblGanttExtendMetas() {
    }
}
