package com.reunico.demo.domain.dto;

import com.reunico.demo.enums.TypeTask;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskResultRsDto {
    private Integer postValue;
    private Integer randomData;
    private Integer sumPVandRandD;
    private TypeTask typeTask;
}
