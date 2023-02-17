package com.saydin.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Locale;
import java.util.TimeZone;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of={"id"})
@Table(name="org_user")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "c_username")
    private String username;

    @Column(name = "c_password")
    private String password;

    @Column(name = "c_firstname")
    private String firstName;

    @Column(name = "c_lastname")
    private String lastName;

    @Column(name = "c_email")
    private String email;


}
