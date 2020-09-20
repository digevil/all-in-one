package org.digevil.dubbo.model.order;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: toni
 * @date: 2020/9/20 2:48 下午
 */
@Data
public class Order {
    private String orderUUID;
    private List<OrderItem> items;
    private Date created;
    private OrderStatus status;
    private String userUUID;
    private int actualTotalFee;
    private int actualShippingFee;
    private int actualDiscount;
    private List<OrderExt> ext;
}
