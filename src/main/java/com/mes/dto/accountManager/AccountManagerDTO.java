package com.mes.dto.accountManager;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class AccountManagerDTO {

    private final Integer id;
    private final Integer accountsId;
    private final String name;
    private final String grade;
    private final String tel;
    private final String email;
    private final String etc;

}
