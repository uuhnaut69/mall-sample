package com.uuhnaut69.mall.search.service;

import com.uuhnaut69.mall.core.utils.Operation;

import java.util.Map;

/**
 * @author uuhnaut
 * @project mall
 */
public interface ProductTagEsService {

    /**
     * Updates/Inserts/Delete product tag data.
     *
     * @param productTagData
     * @param productTagDataBefore
     * @param operation
     * @throws Exception
     */
    void maintainReadModel(Map<String, Object> productTagData, Map<String, Object> productTagDataBefore,
                           Operation operation) throws Exception;
}