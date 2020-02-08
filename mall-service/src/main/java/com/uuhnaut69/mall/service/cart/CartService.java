package com.uuhnaut69.mall.service.cart;

import com.uuhnaut69.mall.domain.model.Cart;
import com.uuhnaut69.mall.payload.request.CartRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
public interface CartService {
    /**
     * Get cart page with admin role
     *
     * @param pageable
     * @return Cart page
     */
    Page<Cart> findAll(Pageable pageable);

    /**
     * Get cart page with user role
     *
     * @param pageable
     * @param userId
     * @return Cart page
     */
    Page<Cart> findAllByUserId(Pageable pageable, UUID userId);

    /**
     * Get cart detail with admin role
     *
     * @param id
     * @return Cart
     * @throws Exception
     */
    Cart findById(UUID id) throws Exception;

    /**
     * Get cart detail with user role
     *
     * @param id
     * @param userId
     * @return Cart
     * @throws Exception
     */
    Cart findByIdAndUserId(UUID id, UUID userId) throws Exception;

    /**
     * Create cart
     *
     * @param cartRequest
     * @param userId
     * @return Cart
     * @throws Exception
     */
    Cart create(CartRequest cartRequest, UUID userId) throws Exception;

    /**
     * Delete cart
     *
     * @param id
     * @param userId
     * @throws Exception
     */
    void delete(UUID id, UUID userId) throws Exception;
}