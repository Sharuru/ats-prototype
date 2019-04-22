package me.sharuru.ats.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_gantt_links")
public class TblGanttLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "t_gantt_links_id_seq")
    private Long id;

    @Column(name = "source")
    private Long source;

    @Column(name = "target")
    private Long target;

    @Column(name = "type")
    private String type;

    public TblGanttLinks() {
    }
}