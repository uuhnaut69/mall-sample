package com.uuhnaut69.mall.search.service;

import com.uuhnaut69.mall.search.document.ProductEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author uuhnaut
 * @project mall
 */
public interface SearchService {

    /**
     * Search product
     *
     * @param text
     * @return Page product
     */
    Page<ProductEs> search(String text, Pageable pageable);

}
