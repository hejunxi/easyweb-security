package com.egao.common.system.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: easyweb-security
 * @description: 航线统计实体
 * @author: hejunxi
 * @create: 2021-03-19 13:53
 **/
@Data
public class AirRoute {

    @ApiModelProperty("航线")
    private String flight;

    @ApiModelProperty("舱位")
    private String cabin;

    @ApiModelProperty("订单量")
    private Integer quantity;

    @ApiModelProperty("票数")
    private Integer passNum;

    @ApiModelProperty("应收")
    private Double receivable;

    @ApiModelProperty("应付")
    private Double handle;

    @ApiModelProperty("利润")
    private Double profit;
}
