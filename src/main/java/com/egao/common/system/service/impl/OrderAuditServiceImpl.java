package com.egao.common.system.service.impl;


import com.alibaba.druid.sql.visitor.functions.Substring;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.egao.common.system.entity.AirRoute;
import com.egao.common.system.entity.SelectOrder;
import com.egao.common.system.entity.StatisticsOrder;
import com.egao.common.system.evt.AirRouteEvt;
import com.egao.common.system.evt.SelectOrderEvt;
import com.egao.common.system.evt.StatisticsOrderEvt;
import com.egao.common.system.mapper.SelectOrderMapper;
import com.egao.common.system.service.OrderAuditService;
import com.sun.media.sound.AiffFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @program: easyweb-security
 * @description: 订单审计实现
 * @author: hejunxi
 * @create: 2021-03-03 16:08
 **/
@Service
public class OrderAuditServiceImpl extends ServiceImpl<SelectOrderMapper, SelectOrder> implements OrderAuditService {


    @Autowired
    private SelectOrderMapper selectOrderMapper;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    DecimalFormat df = new DecimalFormat("######0.00");

    @Override
    public List<SelectOrder> selectOrderList(SelectOrderEvt selectOrderEvt) {
        List<SelectOrder> selectOrderList = selectOrderMapper.select(selectOrderEvt);

        SelectOrder selectOrder = new SelectOrder();
        Double receivableSum = 0.00;
        Double receivedSum = 0.00;
        Double uncollectedSum = 0.00;
        Double handleSum = 0.00;
        Double paidSum = 0.00;
        Double unpaidSum = 0.00;
        Double grossProfitSum = 0.00;
        Double actualProfitSum = 0.00;
        Double actualPaySum = 0.00;
        String text = "总和";
        for (SelectOrder selectOrder1 : selectOrderList) {
            receivableSum += (Double.valueOf(selectOrder1.getReceivable()));
            receivedSum += (Double.valueOf(selectOrder1.getReceived()));
            uncollectedSum += (Double.valueOf(selectOrder1.getUncollected()));
            handleSum += (Double.valueOf(selectOrder1.getHandle()));
            paidSum += (Double.valueOf(selectOrder1.getPaid()));
            unpaidSum += (Double.valueOf(selectOrder1.getUnpaid()));
            grossProfitSum += (Double.valueOf(selectOrder1.getGrossProfit()));
            actualProfitSum += (Double.valueOf(selectOrder1.getActualProfit()));
            actualPaySum += (Double.valueOf(selectOrder1.getActualPay()));
            if (selectOrder1.getOrderStatus().equals("8")) {
                selectOrder1.setOrderStatusVal("出票完成");
            }
            if (selectOrder1.getOrderStatus().equals("10")) {
                selectOrder1.setOrderStatusVal("改签完成");
            }
            if (selectOrder1.getOrderStatus().equals("13")) {
                selectOrder1.setOrderStatusVal("退票完成");
            }
            if (selectOrder1.getOrderType().equals("2")) {
                selectOrder1.setOrderTypeVal("去哪儿");
            }
            if (selectOrder1.getOrderType().equals("3")) {
                selectOrder1.setOrderTypeVal("同程");
            }
            if (selectOrder1.getOrderType().equals("4")) {
                selectOrder1.setOrderTypeVal("淘宝");
            }
            if (selectOrder1.getOrderType().equals("8")) {
                selectOrder1.setOrderTypeVal("携程");
            }
            if (selectOrder1.getOrderType().equals("9")) {
                selectOrder1.setOrderTypeVal("就旅行");
            }
            if (selectOrder1.getOrderType().equals("13")) {
                selectOrder1.setOrderTypeVal("航班管家");
            }
        }
        selectOrder.setOutOrderCode(text);
        selectOrder.setReceivable(receivableSum);
        selectOrder.setReceived(receivedSum);
        selectOrder.setUncollected(uncollectedSum);
        selectOrder.setHandle(handleSum);
        selectOrder.setPaid(paidSum);
        selectOrder.setUnpaid(unpaidSum);
        selectOrder.setGrossProfit(grossProfitSum);
        selectOrder.setActualProfit(actualProfitSum);
        selectOrder.setActualPay(actualPaySum);

        selectOrderList.add(selectOrder);

        return selectOrderList;
    }

    /**
     * 订单统计
     *
     * @param statisticsOrderEvt
     * @return
     */
    @Override
    public List<StatisticsOrder> statisticsOrder(StatisticsOrderEvt statisticsOrderEvt) {

        StatisticsOrderEvt statisticsOrderEvt1 = new StatisticsOrderEvt();


        if (statisticsOrderEvt.getStartDate() == null & statisticsOrderEvt.getEndDate() == null) {
            statisticsOrderEvt1.setStartDate(sdf.format(date));
            statisticsOrderEvt1.setEndDate(sdf.format(date));
            statisticsOrderEvt1.setDepCode(statisticsOrderEvt.getDepCode());
            statisticsOrderEvt1.setOrderStatus(statisticsOrderEvt.getOrderStatus());
            statisticsOrderEvt1.setOrderType(statisticsOrderEvt.getOrderType());
            statisticsOrderEvt1.setPolicySource(statisticsOrderEvt.getPolicySource());
            statisticsOrderEvt1.setTicketMode(statisticsOrderEvt.getTicketMode());
            statisticsOrderEvt1.setAirline(statisticsOrderEvt.getAirline());
        } else if (statisticsOrderEvt.getPolicySource() == null) {
            statisticsOrderEvt1.setStartDate(statisticsOrderEvt.getStartDate());
            statisticsOrderEvt1.setEndDate(statisticsOrderEvt.getEndDate());
            statisticsOrderEvt1.setDepCode(statisticsOrderEvt.getDepCode());
            statisticsOrderEvt1.setOrderStatus(statisticsOrderEvt.getOrderStatus());
            statisticsOrderEvt1.setOrderType(statisticsOrderEvt.getOrderType());
            statisticsOrderEvt1.setPolicySource(statisticsOrderEvt.getPolicySource());
            statisticsOrderEvt1.setTicketMode(statisticsOrderEvt.getTicketMode());
            statisticsOrderEvt1.setAirline(statisticsOrderEvt.getAirline());
        } else if (statisticsOrderEvt.getPolicySource() != null) {
            statisticsOrderEvt1.setStartDate(statisticsOrderEvt.getStartDate());
            statisticsOrderEvt1.setEndDate(statisticsOrderEvt.getEndDate());
            statisticsOrderEvt1.setDepCode(statisticsOrderEvt.getDepCode());
            statisticsOrderEvt1.setOrderStatus(statisticsOrderEvt.getOrderStatus());
            statisticsOrderEvt1.setOrderType(statisticsOrderEvt.getOrderType());
            statisticsOrderEvt1.setPolicySource(statisticsOrderEvt.getPolicySource().toUpperCase());
            statisticsOrderEvt1.setTicketMode(statisticsOrderEvt.getTicketMode());
            statisticsOrderEvt1.setAirline(statisticsOrderEvt.getAirline());
        }

        //调用mapper接收查询结果
        List<StatisticsOrder> statisticsOrders = selectOrderMapper.statisticsOrder(statisticsOrderEvt1);

        statisticsOrders.stream().forEach(ele -> {
            if (ele.getTime().substring(11, 13).equals("00")) {
                ele.setTime(ele.getTime().substring(0, 11) + "0-1");
            }
            if (ele.getTime().substring(11, 13).equals("01")) {
                ele.setTime(ele.getTime().substring(0, 11) + "1-2");
            }
            if (ele.getTime().substring(11, 13).equals("02")) {
                ele.setTime(ele.getTime().substring(0, 11) + "2-3");
            }
            if (ele.getTime().substring(11, 13).equals("03")) {
                ele.setTime(ele.getTime().substring(0, 11) + "3-4");
            }
            if (ele.getTime().substring(11, 13).equals("04")) {
                ele.setTime(ele.getTime().substring(0, 11) + "4-5");
            }
            if (ele.getTime().substring(11, 13).equals("05")) {
                ele.setTime(ele.getTime().substring(0, 11) + "5-6");
            }
            if (ele.getTime().substring(11, 13).equals("06")) {
                ele.setTime(ele.getTime().substring(0, 11) + "6-7");
            }
            if (ele.getTime().substring(11, 13).equals("07")) {
                ele.setTime(ele.getTime().substring(0, 11) + "7-8");
            }
            if (ele.getTime().substring(11, 13).equals("08")) {
                ele.setTime(ele.getTime().substring(0, 11) + "8-9");
            }
            if (ele.getTime().substring(11, 13).equals("09")) {
                ele.setTime(ele.getTime().substring(0, 11) + "9-10");
            }
            if (ele.getTime().substring(11, 13).equals("10")) {
                ele.setTime(ele.getTime().substring(0, 11) + "10-11");
            }
            if (ele.getTime().substring(11, 13).equals("11")) {
                ele.setTime(ele.getTime().substring(0, 11) + "11-12");
            }
            if (ele.getTime().substring(11, 13).equals("12")) {
                ele.setTime(ele.getTime().substring(0, 11) + "12-13");
            }
            if (ele.getTime().substring(11, 13).equals("13")) {
                ele.setTime(ele.getTime().substring(0, 11) + "13-14");
            }
            if (ele.getTime().substring(11, 13).equals("14")) {
                ele.setTime(ele.getTime().substring(0, 11) + "14-15");
            }
            if (ele.getTime().substring(11, 13).equals("15")) {
                ele.setTime(ele.getTime().substring(0, 11) + "15-16");
            }
            if (ele.getTime().substring(11, 13).equals("16")) {
                ele.setTime(ele.getTime().substring(0, 11) + "16-17");
            }
            if (ele.getTime().substring(11, 13).equals("17")) {
                ele.setTime(ele.getTime().substring(0, 11) + "17-18");
            }
            if (ele.getTime().substring(11, 13).equals("18")) {
                ele.setTime(ele.getTime().substring(0, 11) + "18-19");
            }
            if (ele.getTime().substring(11, 13).equals("19")) {
                ele.setTime(ele.getTime().substring(0, 11) + "19-20");
            }
            if (ele.getTime().substring(11, 13).equals("20")) {
                ele.setTime(ele.getTime().substring(0, 11) + "20-21");
            }
            if (ele.getTime().substring(11, 13).equals("21")) {
                ele.setTime(ele.getTime().substring(0, 11) + "21-22");
            }
            if (ele.getTime().substring(11, 13).equals("22")) {
                ele.setTime(ele.getTime().substring(0, 11) + "22-23");
            }
            if (ele.getTime().substring(11, 13).equals("23")) {
                ele.setTime(ele.getTime().substring(0, 11) + "23-24");
            }
        });
        //算总和
        StatisticsOrder statisticsOrder = new StatisticsOrder();
        Integer quantitySum = 0;
        Integer passNumSum = 0;
        Double receivableSum = 0.00;
        Double handleSum = 0.00;
        Double profitSum = 0.00;
        String text = "总和";
        for (StatisticsOrder statisticsOrder1 : statisticsOrders) {
            quantitySum += (statisticsOrder1.getQuantity());
            passNumSum += (statisticsOrder1.getPassNum());
            receivableSum += (Double.valueOf(statisticsOrder1.getReceivable()));
            handleSum += (Double.valueOf(statisticsOrder1.getHandle()));
            profitSum += (Double.valueOf(statisticsOrder1.getProfit()));
        }
        statisticsOrder.setTime(text);
        statisticsOrder.setHandle(Double.valueOf(df.format(handleSum)));
        statisticsOrder.setPassNum(passNumSum);
        statisticsOrder.setQuantity(quantitySum);
        statisticsOrder.setReceivable(Double.valueOf(df.format(receivableSum)));
        statisticsOrder.setProfit(Double.valueOf(df.format(profitSum)));

        statisticsOrders.add(statisticsOrder);


        return statisticsOrders;
    }

    @Override
    public List<AirRoute> airRoute(AirRouteEvt airRouteEvt) {


        //调用mapper接收查询结果
        List<AirRoute> airRoutes = selectOrderMapper.airRoute(airRouteEvt);

        return airRoutes;
    }


}
