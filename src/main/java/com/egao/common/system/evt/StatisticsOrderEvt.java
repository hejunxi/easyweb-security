package com.egao.common.system.evt;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: easyweb-security
 * @description: 订单统计入参
 * @author: hejunxi
 * @create: 2021-03-11 09:36
 **/
@Data
public class StatisticsOrderEvt {

    @ApiModelProperty("订单来源")
    private String orderType;

    @ApiModelProperty("订单状态")
    private String orderStatus;

    @ApiModelProperty("部门")
    private String depCode;

    @ApiModelProperty("出票方式")
    private String ticketMode;

    @ApiModelProperty("政策代码")
    private String policySource;

    @ApiModelProperty("查询开始时间")
    private String StartDate;

    @ApiModelProperty("查询结束时间")
    private String EndDate;

    @ApiModelProperty("航司")
    private String airline;

}
