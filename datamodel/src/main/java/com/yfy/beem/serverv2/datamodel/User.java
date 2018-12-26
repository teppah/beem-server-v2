package com.yfy.beem.serverv2.datamodel;

import lombok.*;

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
    private Long id;
    private String name;
    private String publicKey;
    private String ipAddress;
    private LocalDateTime savedDate;
}
