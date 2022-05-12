package com.mes.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "materials")
@NamedQueries({
        @NamedQuery(name = "Material.countAll", query = "SELECT count(m) FROM Material m"),
        @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m ORDER BY m.id")
})
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "accounts_id")
    private Account account;

    public Material() {
    }

    public Material(Account account) {
        this.account = account;
    }

    private String number;

    private String name;

    private String texture;

    private String sc;

    private String standard;

    private String rm;

    private String shp;

    private String mdt;

    private String mdw;

    private String ml;

    private String unit;

    private String maker;

    @Column(name = "purchase_unit_cost")
    private Integer purchaseUnitCost;

    private Integer price;

    private String storage1;

    private String storage2;

    private String storage3;

    private String etc;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;


    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", account=" + account.getName() +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
