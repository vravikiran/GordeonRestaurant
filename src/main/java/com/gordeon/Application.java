package com.gordeon;

import java.io.File;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.gordeon.business.logic.ComparisonElements;
import com.gordeon.pojo.ItemAndTime;

/**
 * @author Ravikiran
 *class for getting the maximum satisfaction item for a person
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ArrayList<ItemAndTime> items = null;
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		ComparisonElements comparisonElements = ctx
				.getBean(ComparisonElements.class);
		Application application = ctx.getBean(Application.class);
		ClassLoader classLoader = application.getClass().getClassLoader();
		String fileName = classLoader.getResource("data.txt").getFile();
		items = comparisonElements.readDataFromFile(new File(fileName));
		comparisonElements.getMaxSatisfaction(items, 400);
	}
}
