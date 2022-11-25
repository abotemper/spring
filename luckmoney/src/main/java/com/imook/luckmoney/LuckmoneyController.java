package com.imook.luckmoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckmoneyController {

    @Autowired
    private LuckmoneyRepository repository;

    @Autowired
    private  LuckmoneyService service;

    //获取红包列表
    @GetMapping("/luckmoneys")
    public List<Luckmoney> list() {
        return repository.findAll();
    }

    /**
     * 创建红包
     */
    @PostMapping("/luckmoneys")
    public Luckmoney create(@RequestParam("producer") String producer,
                            @RequestParam("money")BigDecimal money){
        Luckmoney luckmoney = new Luckmoney();
        luckmoney.setProducer(producer);
        luckmoney.setMoney(money);
        return  repository.save(luckmoney);

    }


    /**
     * 通过id查询红包
     */
    @GetMapping("/luckmoneys/{id}")
    public Luckmoney findById(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * 更新红包
     */
    @PutMapping("/luckmoneys/{id}")
    public Luckmoney update(@PathVariable("id") Integer id,
                            @RequestParam("consumer") String conssumer) {
        Optional<Luckmoney> optional = repository.findById(id);
        if (optional.isPresent()) {
            Luckmoney luckmoney = optional.get();
            luckmoney.setId(id);
            luckmoney.setConsumer(conssumer);
            return repository.save(luckmoney);
        }
        return null;
    }

    @PostMapping("/luckmoneys/two")
    public  void createTwo() {
        service.createTwo();

    }
}
