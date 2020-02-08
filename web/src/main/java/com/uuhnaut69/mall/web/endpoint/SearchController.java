package com.uuhnaut69.mall.web.endpoint;

import com.uuhnaut69.mall.core.constant.UrlConstants;
import com.uuhnaut69.mall.core.payload.response.GenericResponse;
import com.uuhnaut69.mall.core.utils.PagingUtils;
import com.uuhnaut69.mall.search.document.ProductEs;
import com.uuhnaut69.mall.search.payload.response.AutocompleteResponse;
import com.uuhnaut69.mall.search.service.AutocompleteService;
import com.uuhnaut69.mall.search.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author uuhnaut
 * @project mall
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@Api(tags = "Search", value = "Search Endpoint")
@RequestMapping(path = UrlConstants.BASE_VERSION_API)
public class SearchController {

    private final AutocompleteService autocompleteService;
    private final SearchService searchService;

    /**
     * Complete suggestions product
     *
     * @param text
     * @param size
     * @return GenericResponse
     * @throws Exception
     */
    @ApiOperation(value = "Autocomplete Endpoint", notes = "Public endpoint")
    @GetMapping(path = UrlConstants.PUBLIC_URL + UrlConstants.AUTOCOMPLETE_URL)
    public GenericResponse autocomplete(@RequestParam(value = "text", defaultValue = "") String text,
                                        @RequestParam(value = "size", defaultValue = "25") int size) throws Exception {
        log.info("Autocomplete product with text => {}", text);
        List<AutocompleteResponse> list = autocompleteService.autocomplete(text, size);
        return GenericResponse.builder().data(list).build();
    }

    /**
     * Search product
     *
     * @param text
     * @param sortBy
     * @param order
     * @param page
     * @param pageSize
     * @return GenericResponse
     * @throws Exception
     */
    @ApiOperation(value = "Search Endpoint", notes = "Public endpoint")
    @GetMapping(path = UrlConstants.PUBLIC_URL + UrlConstants.SEARCH_URL)
    public GenericResponse search(@RequestParam(value = "text", defaultValue = "") String text,
                                  @RequestParam(value = "sort", defaultValue = "id") String sortBy,
                                  @RequestParam(value = "order", defaultValue = "desc") String order,
                                  @RequestParam(value = "page", defaultValue = "1") int page,
                                  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws Exception {
        log.info("Search product with text => {}", text);
        Pageable pageable = PagingUtils.makePageRequest(sortBy, order, page, pageSize);
        Page<ProductEs> products = searchService.search(text, pageable);
        return GenericResponse.builder().data(products.getContent()).build();
    }

}