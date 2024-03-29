package com.scs.web.space.api.domain.entity;

import lombok.Data;

/**
 * @author wf
 * @ClassName Account
 * @Description 各个数量的存放
 * @Date 2019/12/4
 */
@Data
public class Account {
    private Integer id;
    private Integer userId;
    private Integer visitorsAccount;
    private Integer messageAccount;
    private Integer ablumAccount;
    private Integer friendAccount;
    private Integer notesAccount;
}
