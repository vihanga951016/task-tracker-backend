package com.vp.tasktrackerbackend.repository.tasks;

import com.vp.tasktrackerbackend.bean.TasksBean;
import com.vp.tasktrackerbackend.repository.MainRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends MainRepository<TasksBean, Integer> {

    @Query("SELECT t FROM TasksBean t WHERE t.id=:id and t.disabled = false")
    TasksBean findTaskById(@Param("id") Integer id);

    @Query("SELECT t FROM TasksBean t WHERE t.id=:id")
    TasksBean findAnyTaskById(@Param("id") Integer id);

    @Query("SELECT t FROM TasksBean t WHERE t.disabled = false")
    List<TasksBean> getAllTasks();

    @Query("update TasksBean t set t.disabled=:status where t.id=:id")
    boolean enableDisableTask(@Param("id")Integer id, @Param("status")boolean status);
}
