package com.egao.common.system.evt;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: easyweb-security
 * @description: 订单审计入参
 * @author: hejunxi
 * @create: 2021-03-02 17:11
 **/
@Data
public class SelectOrderEvt {

    @ApiModelProperty("外部订单号")
    private String outOrderCode;

    @ApiModelProperty("航司订单号")
    private String airOrderCode;

    @ApiModelProperty("订单来源")
    private String orderType;

    @ApiModelProperty("订单状态")
    private String orderStatus;

    @ApiModelProperty("pnr")
    private String pnr;
}
