package org.digevil.allinone.core.model;

import lombok.Data;

@Data
public class Hello {
    private String message;
    private long count;

    public Hello(long count, String message) {
        super();
        this.count = count;
        this.message = message;
    }
}
