package com.mes.dto.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class AccountListDTO {

    private final String accountCode;
    private final String accountName;
    private final String accountKind;

}
