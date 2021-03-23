package com.egao.common.system.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.egao.common.system.entity.AirRoute;
import com.egao.common.system.entity.SelectOrder;
import com.egao.common.system.entity.StatisticsOrder;
import com.egao.common.system.evt.AirRouteEvt;
import com.egao.common.system.evt.SelectOrderEvt;
import com.egao.common.system.evt.StatisticsOrderEvt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface SelectOrderMapper extends BaseMapper<SelectOrder> {

    List<SelectOrder> select(@Param("evt")SelectOrderEvt selectOrderEvt);

    List<StatisticsOrder> statisticsOrder(@Param("evt") StatisticsOrderEvt statisticsOrderEvt);

    List<AirRoute> airRoute(@Param("evt")AirRouteEvt airRouteEvt);
}
