package com.peter.donut;

import com.peter.donut.model.DonutOrder;
import com.peter.donut.service.DonutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DonutController {
    private DonutService donutService;

    private List<DonutOrder> orderList = new ArrayList<>();

    public DonutController(DonutService donutService) {
        this.donutService = donutService;
    }

    @PostMapping("/order")
    public String submitOrder(DonutOrder donutOrder, Model model) {
        model.addAttribute("orderList", orderList);
        model.addAttribute("donutOrder", donutOrder);
        orderList.add(donutOrder);
        donutService.onlineDonutList(orderList);
        return "online-order-view";
    }

    @GetMapping("/order")
    public String displayHistory(Model model) {
        model.addAttribute("orderList", orderList);
        return "online-order-view";
    }
}
