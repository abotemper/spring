package com.imook.luckmoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;

/**
 * @Controller + @ResponseBody = @Restcontroller
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

//    @Value("${minMoney}")
//    private BigDecimal minMoney;
//
//    @Value("${description}")
//    private  String description;
    @Autowired
    private  LimitConfig limitConfig;

//    @GetMapping("/say/{id}")
//    @PostMapping("/say")
    //既能get也能post，但最好还是该弄成post的就弄成post，该弄成get的就弄成get
//    @RequestMapping("/say")
//    public String say(@PathVariable("id") Integer id) {
////        return "description: " + limitConfig.getDescription();
//        return "id: " + id;
//    }
    @GetMapping("/say")//post也是一样
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
//        return "description: " + limitConfig.getDescription();
        return "id: " + id;
    }
}
