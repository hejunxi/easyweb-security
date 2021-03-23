package com.egao.common.system.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Period;
import java.util.List;

/**
 * @program: easyweb-security
 * @description: 订单审计查询实体
 * @author: hejunxi
 * @create: 2021-03-02 17:33
 **/
@Data
public class SelectOrder implements Serializable {

   @ApiModelProperty("外部订单号")
   private String outOrderCode;

   @ApiModelProperty("航司订单号")
   private String airOrderCode;

   @ApiModelProperty("行程")
   private String flight;

   @ApiModelProperty("航班号")
   private String flyCode;

   @ApiModelProperty("出发时间")
   private String depTime;

   @ApiModelProperty("乘机人")
   private String passenger;

   @ApiModelProperty("订单来源")
   private String orderType;

   @ApiModelProperty("订单状态")
   private String orderStatus;

   @ApiModelProperty("部门编号")
   private String depCode;

   private String pnr;

   @ApiModelProperty("应收")
   private Double receivable;

   @ApiModelProperty("已收")
   private Double received;

   @ApiModelProperty("未收")
   private Double uncollected;

   @ApiModelProperty("应付")
   private Double handle;

   @ApiModelProperty("已付")
   private Double paid;

   @ApiModelProperty("未付")
   private Double unpaid;

   @ApiModelProperty("实付")
   private Double actualPay;

   @ApiModelProperty("毛利")
   private Double grossProfit;

   @ApiModelProperty("实际利润")
   private Double actualProfit;

   @ApiModelProperty("订单状态")
   private String orderStatusVal;

   @ApiModelProperty("订单来源")
   private String orderTypeVal;




}
