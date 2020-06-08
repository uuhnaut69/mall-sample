package com.uuhnaut69.mall.payload.request;

import com.uuhnaut69.mall.domain.enums.CouponStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

/**
 * @author uuhnaut
 * @project mall
 */
@Data
public class CouponRequest {

    @NotBlank
    private String code;

    private CouponStatus couponStatus;

    private Double discountPercent;

    private Timestamp startingDate;

    private Timestamp endingDate;
}
