package com.egao.common.system.entity;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @program: easyweb-security
 * @description: 乘客实体
 * @author: hejunxi
 * @create: 2021-03-04 10:25
 **/
@Data
public class PassengerName {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("身份证")
    private String cardNum;

    @ApiModelProperty("票号")
    private String ticketNo;
}
