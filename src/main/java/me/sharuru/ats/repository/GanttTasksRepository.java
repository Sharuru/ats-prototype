package me.sharuru.ats.repository;

import me.sharuru.ats.entity.TblGanttTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GanttTasksRepository extends JpaRepository<TblGanttTasks, Long>, QueryByExampleExecutor<TblGanttTasks> {
}
