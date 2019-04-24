package com.thomascook.contractdemo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonInclude(Include.NON_NULL)
public class ResultResponse {
    private String name;
    private Integer age;
    private boolean isSimpson;
}
