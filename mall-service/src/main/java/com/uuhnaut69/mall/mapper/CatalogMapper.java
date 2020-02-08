package com.uuhnaut69.mall.mapper;

import com.uuhnaut69.mall.domain.model.Catalog;
import com.uuhnaut69.mall.payload.request.CatalogRequest;
import com.uuhnaut69.mall.payload.response.CatalogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
@Mapper(componentModel = "spring")
public interface CatalogMapper {

    /**
     * Mapper code generator from catalog request to catalog entity
     *
     * @param catalogRequest
     * @param id
     * @return Catalog
     */
    @Mapping(source = "id", target = "id")
    Catalog toCatalogEntity(CatalogRequest catalogRequest, UUID id);

    /**
     * Mapper code generator from catalog entity to catalog response
     *
     * @param catalog
     * @return CatalogResponse
     */
    CatalogResponse toCatalogResponse(Catalog catalog);

    /**
     * Mapper code generator from list catalog entity to list catalog response
     *
     * @param catalogs
     * @return List CatalogResponse
     */
    List<CatalogResponse> toListCatalogResponse(List<Catalog> catalogs);
}