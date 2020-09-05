package org.digevil.allinone.service.user.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @Column(name = "id", updatable = false)
    private Integer id;

    @NotNull
    @Column(name = "uuid", updatable = false, unique = true)
    private String uuid;

    @NotNull
    @Column(name = "name")
    private String name;
}
