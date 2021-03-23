package com.egao.common.system.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.egao.common.system.entity.AirRoute;
import com.egao.common.system.entity.SelectOrder;
import com.egao.common.system.entity.StatisticsOrder;
import com.egao.common.system.evt.AirRouteEvt;
import com.egao.common.system.evt.SelectOrderEvt;
import com.egao.common.system.evt.StatisticsOrderEvt;

import java.util.List;

@DS("db2")
public interface OrderAuditService extends IService<SelectOrder> {

    List<SelectOrder> selectOrderList(SelectOrderEvt selectOrderEvt);

    List<StatisticsOrder> statisticsOrder(StatisticsOrderEvt statisticsOrderEvt);

    List<AirRoute> airRoute(AirRouteEvt airRouteEvt);
}
