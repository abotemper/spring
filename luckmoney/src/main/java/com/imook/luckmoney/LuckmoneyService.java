package com.imook.luckmoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Service
public class LuckmoneyService {
    /**
     *
     */
    @Autowired
    private  LuckmoneyRepository repository;

    /**
     * 事务 ,有的引擎支持事务，有的不支持，所谓事务就是一系列sql操作，要么都成功，要么都不成功
     * 比如网购，要扣库存-》创建订单-》这两个必须同时处理
     */

    @Transactional
    public void createTwo() {
        Luckmoney luckmoney1 = new Luckmoney();
        luckmoney1.setProducer("albert");
        luckmoney1.setMoney(new BigDecimal("520"));
        repository.save(luckmoney1);

        Luckmoney luckmoney2 = new Luckmoney();
        luckmoney2.setProducer("albert");
        luckmoney2.setMoney(new BigDecimal("1314"));
        repository.save(luckmoney2);

    }




}
