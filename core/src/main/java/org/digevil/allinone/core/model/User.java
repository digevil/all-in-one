package org.digevil.allinone.core.model;

import lombok.Data;

import java.util.UUID;

/**
 * @author toni
 */
@Data
public class User {

    private int id;

    private UUID uuid;

    private String name;
}
