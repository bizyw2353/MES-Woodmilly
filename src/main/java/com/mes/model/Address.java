package com.mes.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "address")
    private String address;

    @Column(name = "address_detail")
    private String addressDetail;

    public Address() {
    }

    public Address(String zipCode, String address, String addressDetail) {
        this.zipCode = zipCode;
        this.address = address;
        this.addressDetail = addressDetail;
    }
}
