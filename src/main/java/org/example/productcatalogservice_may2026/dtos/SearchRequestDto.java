package org.example.productcatalogservice_may2026.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class SearchRequestDto {
    private String query;
    private Integer pageSize;   // so that i can play  with different values
    private Integer pageNumber;
    private List<SortParam> sortParams = new ArrayList<>();
}
