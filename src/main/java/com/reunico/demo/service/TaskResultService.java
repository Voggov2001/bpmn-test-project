package com.reunico.demo.service;

import com.reunico.demo.domain.dto.PostValueDto;
import com.reunico.demo.domain.dto.StartEntity;
import com.reunico.demo.domain.dto.TaskResultRsDto;
import com.reunico.demo.feign.FeignCamunda;
import com.reunico.demo.mapper.TaskResultMapper;
import com.reunico.demo.rep.TaskResultRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TaskResultService {

    @Autowired
    private final FeignCamunda feignCamunda;

    @Autowired
    private final TaskResultRepositoty taskResultRepositoty;

    @Autowired
    private final TaskResultMapper mapper;

    public TaskResultService(FeignCamunda feignCamunda, TaskResultRepositoty taskResultRepositoty, TaskResultMapper mapper) {
        this.feignCamunda = feignCamunda;
        this.taskResultRepositoty = taskResultRepositoty;
        this.mapper = mapper;
    }

    public ResponseEntity<Map> start(Integer postValue) {
        PostValueDto postValueDto = new PostValueDto(postValue);
        Map<String, PostValueDto> map = new HashMap<>();
        map.put("postValue", postValueDto);
        StartEntity start = StartEntity.builder()
                .variables(map)
                .businessKey("app-process")
                .build();
        return feignCamunda.start(start);
    }

    public ResponseEntity<LinkedList<Map>> getTasks() {
        return feignCamunda.tasks();
    }

    public ResponseEntity<Map> completeTask(String id, StartEntity start) {
        return feignCamunda.completeTask(id, start);
    }

    public List<TaskResultRsDto> getResult() {
        return taskResultRepositoty.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }
}
