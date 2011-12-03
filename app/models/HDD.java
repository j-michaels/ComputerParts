package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.*;
import play.data.validation.*;

@Entity
public class HDD extends Model {
	@Required
	public int capacity;
	
	@Required
	public String name;
	
	@Required
	public String brand;
	
	public HDD(String name) {
    	this.name = name;
    	this.brand = "ASUS";
	}
}
