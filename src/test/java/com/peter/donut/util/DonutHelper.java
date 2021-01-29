package com.peter.donut.util;

import com.peter.donut.model.DonutOrder;

import java.util.ArrayList;
import java.util.List;

public class DonutHelper {

    public DonutOrder buildDonutOrder() {
        DonutOrder donutOrder = new DonutOrder();
        donutOrder.setFirstName("Peter");
        donutOrder.setSurname("Khayundi");
        donutOrder.setOrderDate("29/01/2021");
        donutOrder.setNumberOfDonuts(20);

        return donutOrder;
    }

    public List<DonutOrder> buildOrderList() {
        List<DonutOrder> donutOrderList = new ArrayList<>();

        DonutOrder donutOrder = new DonutOrder();
        donutOrder.setFirstName("Peter");
        donutOrder.setSurname("Khayundi");
        donutOrder.setOrderDate("29/01/2021");
        donutOrder.setNumberOfDonuts(20);

        DonutOrder donutOrder1 = new DonutOrder();
        donutOrder1.setFirstName("Sibo");
        donutOrder1.setSurname("Ngoma");
        donutOrder1.setOrderDate("29/01/2021");
        donutOrder1.setNumberOfDonuts(8);

        donutOrderList.add(donutOrder);
        donutOrderList.add(donutOrder1);

        return donutOrderList;
    }
}
