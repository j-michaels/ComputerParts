package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.*;
import play.data.validation.*;

@Entity
public class HD extends Model {
	@Required
	public int capacity;
	
	@Required
	public String name;
	
	@Required
	public String maker;
	
	public boolean ssd;
	
	public String model;
	public int discspeed;
	public String intrface;
	public int interfaceSpeed;
	public int wattage;
	public double price;
	
	
	public HD(String name) {
    	this.name = name;
    	this.maker = "ASUS";
	}
}
