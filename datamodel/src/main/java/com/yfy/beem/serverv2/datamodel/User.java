package com.yfy.beem.serverv2.datamodel;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Class that represents a single user.
 * */
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Builder
public class User {
    @Id
    @Column(name="id",nullable = false, updatable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "key", nullable = false)
    private String publicKey;
    @Column(name = "ip", nullable = false)
    private String ipAddress;

}
