package me.sharuru.ats.repository;

import me.sharuru.ats.entity.TblGanttExtendMetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GanttExtendMetasRepository extends JpaRepository<TblGanttExtendMetas, Long>, QueryByExampleExecutor<TblGanttExtendMetas> {
}
