package com.peter.donut.service;

import com.peter.donut.model.DonutOrder;

import java.util.List;

public interface DonutService {
    List<DonutOrder> onlineDonutList(List<DonutOrder> donutList);
}
