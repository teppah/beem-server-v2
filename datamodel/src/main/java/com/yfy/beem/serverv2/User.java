package com.yfy.beem.serverv2;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class that represents a single user. //TODO write javadoc for the different fields
 * */
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    private Long id;
    private String name;
    private String publicKey;
    private String ipAddress;
}
