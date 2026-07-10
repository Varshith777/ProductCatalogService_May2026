package org.example.productcatalogservice_may2026.services;

import org.example.productcatalogservice_may2026.dtos.SortParam;
import org.example.productcatalogservice_may2026.dtos.SortType;
import org.example.productcatalogservice_may2026.models.Product;
import org.example.productcatalogservice_may2026.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaBasedSearchService implements ISearchService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Page<Product> searchProducts(String query, Integer pageSize, Integer pageNumber, List<SortParam> sortParams) {
//        Sort sortByPriceDesc = Sort.by("price").descending();
//        Sort sortByIdDesc = Sort.by("id").descending();
//        Sort sort = sortByPriceDesc.and(sortByIdDesc);

        Sort sort = null;
        if (!sortParams.isEmpty()) {
            if (sortParams.get(0).getSortType().equals(SortType.ASC))
                sort = Sort.by(sortParams.get(0).getParamName());
            else
                sort = Sort.by(sortParams.get(0).getParamName()).descending();

            for(int i=1;i<sortParams.size();i++) {
                Sort intSort = null;
                if (sortParams.get(i).getSortType().equals(SortType.ASC))
                     intSort = Sort.by(sortParams.get(i).getParamName());
                else
                    intSort = Sort.by(sortParams.get(i).getParamName()).descending();
                sort = sort.and(intSort);
            }
        }

        if(sort != null)
             return productRepo.findByNameEquals(query, PageRequest.of(pageNumber,pageSize,sort));
        else
            return productRepo.findByNameEquals(query, PageRequest.of(pageNumber,pageSize));
    }
}


//{
//        "query" : "laptop",
//        "pageNumber" : 0,
//        "pageSize" : 10,
//        "sortParams" : [
//        {
//        "paramName" : "price",
//        "sortType" : "DESC"
//        },
//        {
//        "paramName" : "id",
//        "sortType" : "DESC"
//        }
//        ]
//        }