package com.reunico.demo.mapper;

import com.reunico.demo.domain.TaskResult;
import com.reunico.demo.domain.dto.TaskResultRsDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskResultMapper {

    private final ModelMapper mapper;

    public TaskResultMapper() {
        this.mapper = new ModelMapper();
    }

    public TaskResultRsDto mapToDto(TaskResult taskResult) {
        return mapper.map(taskResult, TaskResultRsDto.class);
    }

    public TaskResult mapToTaskResult(TaskResultRsDto taskResultRsDto) {
        return mapper.map(taskResultRsDto, TaskResult.class);
    }
}
