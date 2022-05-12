package com.mes.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users", catalog = "mes_taemyung")
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(name = "User.checkLogin", query = "SELECT u FROM User u WHERE u.userId = :userId AND u.password = :password")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
