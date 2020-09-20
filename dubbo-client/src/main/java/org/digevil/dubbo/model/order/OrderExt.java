package org.digevil.dubbo.model.order;

import lombok.Data;

/**
 * @author: toni
 * @date: 2020/9/20 3:00 下午
 */
@Data
public abstract class OrderExt<T> {
    private String extKey;
    private T extValue;
}
