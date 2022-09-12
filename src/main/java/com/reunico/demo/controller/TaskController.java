package com.reunico.demo.controller;

import com.reunico.demo.domain.dto.StartEntity;
import com.reunico.demo.domain.dto.TaskResultRsDto;
import com.reunico.demo.rep.TaskResultRepositoty;
import com.reunico.demo.service.TaskResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @Autowired
    private final TaskResultService taskResultService;

    @Autowired
    private final TaskResultRepositoty taskResultRepositoty;


    public TaskController(TaskResultService resultService, TaskResultRepositoty taskResultRepositoty) {
        this.taskResultService = resultService;
        this.taskResultRepositoty = taskResultRepositoty;
    }

    @PostMapping("/start/{postValue}")
    public ResponseEntity<Map> start(@PathVariable Integer postValue) {
        return taskResultService.start(postValue);
    }

    @GetMapping("/tasks")
    public ResponseEntity<LinkedList<Map>> getTasks() {
        return taskResultService.getTasks();
    }

    @PostMapping("/completetask/{id}")
    public ResponseEntity<Map> completeTask(@PathVariable String id, @RequestBody StartEntity start) {
        return taskResultService.completeTask(id, start);
    }

    @GetMapping(value = "/result", produces = "application/json")
    public List<TaskResultRsDto> getResult() {
        return taskResultService.getResult();
    }

}
