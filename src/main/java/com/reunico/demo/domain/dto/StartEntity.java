package com.reunico.demo.domain.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
@Builder
public class StartEntity {
    private Map<String, PostValueDto> variables;
    private String businessKey;
}
