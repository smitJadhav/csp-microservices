package com.csp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GridResponse<T> {

    private Long count;

    private List<T> records;
}
