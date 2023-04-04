package com.vp.tasktrackerbackend.services;

import com.vp.tasktrackerbackend.bean.TasksBean;
import com.vp.tasktrackerbackend.repository.tasks.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;

    public ResponseEntity addTask(TasksBean bean) {
        return new ResponseEntity<>(tasksRepository.save(bean), HttpStatus.OK);
    }

    public ResponseEntity updateTask(TasksBean bean) {
        TasksBean tasksBean = tasksRepository.findTaskById(bean.getId());
        if(tasksBean == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Task Not Found");
        }
        return new ResponseEntity<>(tasksRepository.save(bean), HttpStatus.OK);
    }

    public ResponseEntity getTaskById(Integer id) {
        TasksBean tasksBean = tasksRepository.findTaskById(id);
        if(tasksBean == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Task Not Found");
        }
        return new ResponseEntity<>(tasksBean, HttpStatus.OK);
    }

    public ResponseEntity getAllTasks() {
        return new ResponseEntity<>(tasksRepository.getAllTasks(), HttpStatus.OK);
    }

    public ResponseEntity deleteTasks(Integer id) {
        TasksBean tasksBean = tasksRepository.findTaskById(id);
        if(tasksBean == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Task Not Found");
        }
        tasksRepository.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    public ResponseEntity enableDisableTask(Integer id) {
        TasksBean tasksBean = tasksRepository.findAnyTaskById(id);
        if(tasksBean == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Task Not Found");
        }

        tasksBean.setDisabled(!tasksBean.isDisabled());
        return new ResponseEntity<>(tasksRepository.save(tasksBean), HttpStatus.OK);
    }

    public ResponseEntity doneTask(Integer id){
        TasksBean tasksBean = tasksRepository.findAnyTaskById(id);
        if(tasksBean == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Task Not Found");
        }

        tasksBean.setDone(!tasksBean.isDone());
        return new ResponseEntity<>(tasksRepository.save(tasksBean), HttpStatus.OK);
    }
}
