package com.gordeon.business.logic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.gordeon.pojo.ItemAndTime;

/**
 * @author Ravikiran
 * class to compare the itemandtime data to get the maximum satisfaction item for a person in restaurant
 *
 */
@Component
public class ComparisonElements {
	/**
	 * method for reading data from a file
	 */
	public ArrayList<ItemAndTime> readDataFromFile(File file) {
		String data[]=null;
		ArrayList<ItemAndTime> items= null;
		if(file != null) {
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
			Stream<String>dataStream = bufferedReader.lines();
			Iterator<String> iterator= dataStream.iterator();
			items = new ArrayList<>();
			while(iterator.hasNext()) {
				data=iterator.next().split(" ");
				items.add(new ItemAndTime(new Integer(data[0]), new Integer(data[1])));
			}
			
		}catch(IOException exception) {
			exception.getMessage();
		} 
		} else {
			System.out.println("no file is available to read the data");
		}
		return items;
	}
	
	/**
	 * method to compare the ItemAndTime data to get the maximum satisfaction item for a person 
	 */
	public void getMaxSatisfaction(ArrayList<ItemAndTime> items, int time) {
		if(items.size()>0) {
			ArrayList<ItemAndTime> satiItems = new ArrayList<>();
			for (ItemAndTime itemAndTime : items) {
				if(itemAndTime.getTimeToEat()<=time) {
					satiItems.add(itemAndTime);
				}
			}
			satiItems.sort(Comparator.comparing(ItemAndTime::getAmtOfSati).thenComparing(ItemAndTime::getTimeToEat));
			Collections.reverse(satiItems);
			System.out.println("Element details with maximum satisfaction:    "+"AMOUNT OF SATISFACTION::"+satiItems.get(0).getAmtOfSati()+", TIME TO EAT::"+satiItems.get(0).getTimeToEat());
		} else {
			System.out.println("No items available to get maximum satisfaction");
		}
	}

}
