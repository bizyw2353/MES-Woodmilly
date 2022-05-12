package com.mes.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounts_manager", catalog = "mes_taemyung")
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(name = "AccountManager.findAll", query = "SELECT am FROM AccountManager am ORDER BY am.createdAt DESC")
})
@DynamicUpdate
public class AccountManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "accounts_id")
    private Integer accountsId;

    @Column(name = "name")
    private String name;

    @Column(name = "grade")
    private String grade;

    @Column(name = "tel")
    private String tel;

    @Column(name = "etc")
    private String etc;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;


}
