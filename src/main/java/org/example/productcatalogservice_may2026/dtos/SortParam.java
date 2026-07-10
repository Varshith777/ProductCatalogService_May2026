package org.example.productcatalogservice_may2026.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SortParam {
    private String paramName;
    private SortType sortType;
}
