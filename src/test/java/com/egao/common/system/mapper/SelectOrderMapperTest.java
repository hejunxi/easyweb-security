package com.egao.common.system.mapper;

import com.egao.common.system.entity.SelectOrder;
import com.egao.common.system.evt.SelectOrderEvt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SelectOrderMapperTest {

    @Autowired
    private SelectOrderMapper mapper;
//
//    @Test
//    public void select() {
//        List<SelectOrder>  list = mapper.select(SelectOrderEvt);
//        System.out.println(list);
//    }
}