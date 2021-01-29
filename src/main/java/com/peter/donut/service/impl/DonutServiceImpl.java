package com.peter.donut.service.impl;

import com.peter.donut.model.DonutOrder;
import com.peter.donut.service.DonutService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonutServiceImpl implements DonutService {

    @Override
    public List<DonutOrder> onlineDonutList(List<DonutOrder> donutList) {
        // sort the list
        Comparator<DonutOrder> compareByDateThenName = Comparator
                .comparing(DonutOrder::getCollectionDate)
                .thenComparing(DonutOrder::getSurname);

        List<DonutOrder> sortedOrder = donutList.stream()
                .sorted(compareByDateThenName)
                .collect(Collectors.toList());

        // determine orders
        List<DonutOrder> finalList = new ArrayList<>();
        int runningTotal = 0;
        int cinnamonCount = 0;
        int jamCount = 0;
        int creamCount = 0;
        int sprinklesCount = 0;
        int numberOfDonuts = 0;
        for (DonutOrder order : sortedOrder) {
            numberOfDonuts = order.getNumberOfDonuts();
            runningTotal += numberOfDonuts;
            for (int i = 0; i < numberOfDonuts; i++) {
                if (i == 0 && runningTotal >0) {
                    cinnamonCount++;
                    runningTotal--;
                }
                if (numberOfDonuts >= 3) {
                    jamCount++;
                    runningTotal -= 4;
                }
                if (numberOfDonuts >= 5) {
                    creamCount++;
                    runningTotal -= 10;
                }
                if (numberOfDonuts >= 15) {
                    sprinklesCount++;
                    runningTotal -= 15;
                }
            }

            order.setCinnamonCount(cinnamonCount);
            order.setJamCount(jamCount);
            order.setCreamCount(creamCount);
            order.setSprinklesCount(sprinklesCount);
            finalList.add(order);
        }
        return finalList;
    }
}
