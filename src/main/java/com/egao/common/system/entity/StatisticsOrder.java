package com.egao.common.system.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: easyweb-security
 * @description: 订单统计查询实体
 * @author: hejunxi
 * @create: 2021-03-11 09:48
 **/
@Data
public class StatisticsOrder implements Serializable {

    @ApiModelProperty("时间")
    private String time;

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
