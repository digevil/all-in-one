package org.digevil.dubbo.model.order;

import lombok.Data;

/**
 * @author: toni
 * @date: 2020/9/20 2:49 下午
 */
@Data
public class OrderItem {
    private String itemUUID;
    private int quantity;
    private int totalFee;
    private int discount;
    private int shippingFee;
}
