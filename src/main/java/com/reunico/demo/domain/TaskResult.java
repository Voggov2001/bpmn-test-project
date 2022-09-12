package com.reunico.demo.domain;

import com.reunico.demo.enums.TypeTask;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskResult implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer postValue;
    private Integer randomData;
    private Integer sumPVandRandD;
    private TypeTask typeTask;
}
