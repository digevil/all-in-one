package org.digevil.dubbo.service;

import org.digevil.dubbo.model.order.Order;

/**
 * @author: toni
 * @date: 2020/9/20 2:47 下午
 */
public interface IOrderService {

    /**
     * @param order
     * @return
     */
    public Order createOrder(Order order);

    /**
     * @param orderUUID
     * @return
     */
    public Order findOrderByUUID(String orderUUID);

}
