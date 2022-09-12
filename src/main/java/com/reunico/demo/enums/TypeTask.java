package com.reunico.demo.enums;


import lombok.Getter;

@Getter
public enum TypeTask {

    TASK_A("Задача А"), TASK_B("Задача Б");

    final String name;
    TypeTask(String s) {
        name = s;
    }
}
