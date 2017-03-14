package com.gordeon;

import java.io.File;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gordeon.business.logic.ComparisonElements;
import com.gordeon.pojo.ItemAndTime;
/**
 * @author Ravikiran
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={ComparisonElements.class})
public class ApplicationTests {
	
	@Autowired
	private ComparisonElements comparisonElements; 

	@Test
	public void contextLoads() {
	}
	
	/**
	 * method to test reading data from a valid file
	 */
	@Test
	public void testReadDataFromFile() {

		Assert.assertNotNull(comparisonElements.readDataFromFile(new File("/data.txt")));
	}
	
	/**
	 * method to test reading data from a file when file is null
	 */
	@Test
	public void testReadDataFromNullFile() {
		Assert.assertNull(comparisonElements.readDataFromFile(null));
	}
	
	/**
	 * method to test reading data from a file which is not available
	 */
	@Test
	public void testReadDataFromFileNotAvl() {
		Assert.assertNull(comparisonElements.readDataFromFile(new File("Nofile.txt")));
	}
	/**
	 * method to test get maximum satisfaction when there are no items available
	 */
	@Test
	public void testGetMaxSatisfactionWithNoData(){
		comparisonElements.getMaxSatisfaction(new ArrayList<ItemAndTime>(), 30);
	}
	
	/**
 	 * method to test get maximum satisfaction when items are available
	 */
	@Test
	public void testGetMaxSatisfactionWithData(){
		ArrayList<ItemAndTime> items = new ArrayList<ItemAndTime>();
		items.add(new ItemAndTime(20, 2800));
		items.add(new ItemAndTime(45,6009));
		items.add(new ItemAndTime(789, 98706));
		comparisonElements.getMaxSatisfaction(items, 100);
		
	}
}
