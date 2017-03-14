package com.gordeon.pojo;


/**
 * @author Ravikiran
 *POJO object for every itemandtime data read from the file
 *
 */
public class ItemAndTime {
 private int amtOfSati =0;
 private int timeToEat=0;

 public int getAmtOfSati() {
	return amtOfSati;
}
public void setAmtOfSati(int amtOfSati) {
	this.amtOfSati = amtOfSati;
}
public int getTimeToEat() {
	return timeToEat;
}
public void setTimeToEat(int timeToEat) {
	this.timeToEat = timeToEat;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + amtOfSati;
	result = prime * result + timeToEat;
	return result;
}

public ItemAndTime(int amtOfSati, int timeToEat) {
	super();
	this.amtOfSati = amtOfSati;
	this.timeToEat = timeToEat;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ItemAndTime other = (ItemAndTime) obj;
	if (amtOfSati != other.amtOfSati)
		return false;
	if (timeToEat != other.timeToEat)
		return false;
	return true;
}
@Override
public String toString() {
	return "ItemAndTime [amtOfSati=" + amtOfSati + ", timeToEat=" + timeToEat + "]";
}
 
}
