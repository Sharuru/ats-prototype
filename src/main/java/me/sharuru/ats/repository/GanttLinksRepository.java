package me.sharuru.ats.repository;

import me.sharuru.ats.entity.TblGanttLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GanttLinksRepository extends JpaRepository<TblGanttLinks, Long>, QueryByExampleExecutor<TblGanttLinks> {
}
