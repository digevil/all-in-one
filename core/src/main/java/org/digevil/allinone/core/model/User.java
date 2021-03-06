package org.digevil.allinone.core.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author toni
 */
@Entity
@Table(name = "aio_users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "name")
    private String name;
}
