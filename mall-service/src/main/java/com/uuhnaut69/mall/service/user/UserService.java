package com.uuhnaut69.mall.service.user;

import com.uuhnaut69.mall.domain.model.User;
import com.uuhnaut69.mall.payload.request.UserBaseContent;

import java.util.UUID;

/**
 * @author uuhnaut
 * @project mall
 */
public interface UserService {
    /**
     * Find user by id
     *
     * @param id
     * @return User
     */
    User findById(UUID id);

    /**
     * Save
     *
     * @param user
     */
    void save(User user);

    /**
     * Init content user wanna see
     *
     * @param id
     * @param userBaseContent
     * @throws Exception
     */
    void initBaseContent(UUID id, UserBaseContent userBaseContent) throws Exception;

    /**
     * Save uuid product that user has seen
     *
     * @param userId
     * @param productId
     * @throws Exception
     */
    void markAsReadProduct(UUID userId, UUID productId) throws Exception;
}
