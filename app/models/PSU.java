package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.*;
import play.data.validation.*;

@Entity
public class PSU extends Model {
	
	@Required
	public String maker;
	
	@Required
	public String name;
	
	public int wattage;
	public double price;
	public String model;
	public PSU(String name) {
    	this.name = name;
	}
}
