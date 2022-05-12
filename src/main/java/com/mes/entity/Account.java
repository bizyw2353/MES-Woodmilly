package com.mes.entity;

import com.mes.model.Address;
import com.mes.model.Business;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounts", catalog = "mes_taemyung")
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account  a ORDER BY a.createdAt DESC"),
        @NamedQuery(name = "Account.countAll", query = "SELECT count(a) FROM Account a")
})
@DynamicUpdate //변경 된 컬럼만 찾아서 업데이트를 진행
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "accounts_code")
    private String code;

    @Column(name = "name")
    private String name;

    @Embedded
    private Business business;

    @Column(name = "ceo")
    private String ceo;

    @Column(name = "tel")
    private String tel;

    @Column(name = "fax")
    private String fax;

    @Column(name = "email")
    private String email;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code1")),
            @AttributeOverride(name = "address", column = @Column(name = "address1")),
            @AttributeOverride(name = "addressDetail", column = @Column(name = "address_detail1"))
    })
    private Address address1;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code2")),
            @AttributeOverride(name = "address", column = @Column(name = "address2")),
            @AttributeOverride(name = "addressDetail", column = @Column(name = "address_detail2"))
    })
    private Address address2;

    @Column(name = "etc")
    private String etc;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
}
