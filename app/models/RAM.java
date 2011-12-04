package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.*;

@Entity
public class RAM extends Model {
	public int speed;
	public int amount;
	public String requires;
	public String model;
	public String maker;
	
	public double power;
	public int capacity;
	public double price;
	public String type;
	
	
	public String getName() {
		return maker + " " + model;
	}
	
	public RAM(String name) {
    	
	}
}
