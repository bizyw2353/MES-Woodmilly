package com.mes.dto.material;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class MaterialDTO {
    private Integer id;
    private Integer accountId;
    private String accountName;
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
    private Integer purchaseUnitCost;
    private Integer price;
    private String storage1;
    private String storage2;
    private String storage3;
    private String etc;
    private Date createdAt;
    private Date updatedAt;
}
