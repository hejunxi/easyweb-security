package com.egao.common.system.controller;

import com.egao.common.core.annotation.OperLog;
import com.egao.common.core.web.BaseController;
import com.egao.common.core.web.JsonResult;
import com.egao.common.core.web.PageParam;
import com.egao.common.system.entity.AirRoute;
import com.egao.common.system.entity.SelectOrder;
import com.egao.common.system.entity.StatisticsOrder;
import com.egao.common.system.evt.AirRouteEvt;
import com.egao.common.system.evt.SelectOrderEvt;
import com.egao.common.system.evt.StatisticsOrderEvt;
import com.egao.common.system.service.OrderAuditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: easyweb-security
 * @description: 测试
 * @author: hejunxi
 * @create: 2021-03-01 13:52
 **/
@Api(tags = "订单审计")
@RestController
@RequestMapping("/api/orderAudit")
public class OrderAuditController extends BaseController {

    @Autowired
    private OrderAuditService orderAuditService;

    @PreAuthorize("hasAuthority('sys:user:list')")
    @OperLog(value = "订单管理", desc = "查询全部")
    @ApiOperation("查询所有订单")
    @GetMapping("/all")
    public JsonResult selectOrder(SelectOrderEvt selectOrderEvt) {
        PageParam<SelectOrder> pageParam = new PageParam<>();
        List<SelectOrder> selectOrderList = orderAuditService.selectOrderList(selectOrderEvt);
        return JsonResult.ok().setData(pageParam.sortRecords(selectOrderList));
    }

    @PreAuthorize("hasAuthority('sys:user:list')")
    @ApiOperation("统计所有订单")
    @GetMapping("/order")
    public JsonResult statisticsOrder(StatisticsOrderEvt statisticsOrderEvt) {
        PageParam<StatisticsOrder> pageParam = new PageParam<>();
        List<StatisticsOrder> statisticsOrder = orderAuditService.statisticsOrder(statisticsOrderEvt);
        return JsonResult.ok().setData(pageParam.sortRecords(statisticsOrder));
    }

    @PreAuthorize("hasAuthority('sys:user:list')")
    @ApiOperation("统计所有订单")
    @GetMapping("/airRoute")
    public JsonResult airRoute(AirRouteEvt airRouteEvt) {
        PageParam<AirRoute> pageParam = new PageParam<>();
        List<AirRoute> airRoutes = orderAuditService.airRoute(airRouteEvt);
        return JsonResult.ok().setData(pageParam.sortRecords(airRoutes));
    }


}


