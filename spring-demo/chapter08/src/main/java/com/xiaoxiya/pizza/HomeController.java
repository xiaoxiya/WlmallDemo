package com.xiaoxiya.pizza;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luopeng
 * @date 2019/10/30 22:09
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String redirectToFlow() {
        return "redirect:/pizza";
    }
}
