package com.egao.common.system.evt;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: easyweb-security
 * @description: 航线统计查询入参
 * @author: hejunxi
 * @create: 2021-03-19 14:56
 **/
@Data
public class AirRouteEvt {

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

    @ApiModelProperty("出发")
    private String dep;

    @ApiModelProperty("到达")
    private String arr;

    @ApiModelProperty("舱位")
    private String cabin;
}
