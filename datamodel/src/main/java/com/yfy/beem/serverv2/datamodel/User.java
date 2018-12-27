package com.yfy.beem.serverv2.datamodel;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

/**
 * Class that represents a single user.
 */
@Entity
@Table(name = "users")
@Data
//@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Builder
public class User {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "key")
    private String publicKey;
    @Column(name = "ip")
    private String ipAddress;

    public User(Long id, String name, String publicKey, String ipAddress) {
        this.id = Objects.requireNonNullElseGet(id, () -> new Random().nextLong());
        this.name = name;
        this.publicKey = publicKey;
        this.ipAddress = ipAddress;
    }
}
