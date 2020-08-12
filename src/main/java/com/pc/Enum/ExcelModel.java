package com.pc.Enum;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author panchi
 * @Type ExcelModel.java
 * @Desc
 * @date 2020/4/24 20:15
 */
@Getter
@Setter
@ToString
public class ExcelModel implements Serializable {
    //serializableNumber
    /**
     * 付费产品名称，必填
     */
    private String payProduct;

    /**
     * 付费类型（必填。0:单月；1:单季；2:半年；3:一年；4:两年 5:单次）
     */
    private String priceType;

    /**
     * 支付方式(必填，1：苹果支付；2：话费支付；3：第三方支付)
     */
    private String deviceType;

    /**
     * 价格，必填
     */
    private BigDecimal productPrice;

    /**
     * 付费产品Id（必填）
     */
    private String productId;

    /**
     * 苹果支付Id（选填，当支付方式为苹果支付时填写）
     */
    private String appleId;
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2020/4/24 panchi create
 */ 
