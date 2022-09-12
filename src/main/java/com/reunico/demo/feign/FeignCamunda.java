package com.reunico.demo.feign;

import com.reunico.demo.domain.dto.StartEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.LinkedList;
import java.util.Map;

@FeignClient(name = "start", url = "http://localhost:8080/rest")
public interface FeignCamunda {
    @PostMapping(path = "/process-definition/key/app-process/start", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Map> start(@RequestBody StartEntity start);

    @GetMapping(path = "/task", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<LinkedList<Map>> tasks();

    @PostMapping(path = "/task/{id}/complete")
    ResponseEntity<Map> completeTask(@PathVariable String id, @RequestBody StartEntity start);
}
