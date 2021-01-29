package com.peter.donut;

import com.peter.donut.model.DonutOrder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DonutApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DonutApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running Spring Boot Application");
		processOrder();
	}

	private void processOrder() {
		String fileName = "static/donuts.txt";
		String stringSplitBy = ",";
		String collectionDate;
		String orderDate;
		String name;
		String firstName;
		String surname;
		int runningTotal = 0;
		int cinnamonCount = 0;
		int jamCount = 0;
		int creamCount = 0;
		int sprinklesCount = 0;
		List<DonutOrder> orderList = new ArrayList<>();
		List<DonutOrder> sortedOrder = new ArrayList<>();

		ClassLoader classLoader = getClass().getClassLoader();

		try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
			if (inputStream != null) {
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
				while (br.ready()) {
					String result = br.readLine();
					String[] values = result.split(stringSplitBy);
					orderDate = values[0];
					collectionDate = values[1];
					name = values[2];

					// split name into first name and surname
					int index = name.indexOf(' ');
					firstName = name.substring(0, index);
					surname = name.substring(index + 1);

					// determine order count by using running total
					String numberOfDonuts = values[3];
					runningTotal += Integer.parseInt(numberOfDonuts);

					orderList.add(new DonutOrder(firstName, surname, orderDate, collectionDate, Integer.parseInt(numberOfDonuts)));
				}

				// sort the orders according to collection date then surname
				Comparator<DonutOrder> compareByDateThenName = Comparator
						.comparing(DonutOrder::getCollectionDate)
						.thenComparing(DonutOrder::getSurname);

				sortedOrder = orderList.stream()
						.sorted(compareByDateThenName)
						.collect(Collectors.toList());
			}

			List<DonutOrder> finalList = new ArrayList<>();
			int numberOfDonuts;
			for (DonutOrder order : sortedOrder) {
				numberOfDonuts = order.getNumberOfDonuts();
				for (int i = 1; i <= numberOfDonuts; i++) {
					if (i == 1 && runningTotal != 0) {
						cinnamonCount++;
						runningTotal--;
					}
					if (i == 3 && runningTotal != 0) {
						jamCount++;
						runningTotal -= 3;
					}
					if (i == 5 && runningTotal != 0) {
						creamCount++;
						runningTotal -= 5;
					}
					if (i == 15 && runningTotal != 0) {
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
			System.out.println(Arrays.toString(finalList.toArray()));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
