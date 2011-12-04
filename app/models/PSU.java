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
	
	public int wattage;
	public double price;
	public String model;
	
    public String getName() {
    	return maker + " " + model;
    }
    
	
	public PSU(String name) {
    	
	}
}
