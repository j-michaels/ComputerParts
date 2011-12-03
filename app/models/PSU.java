package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.*;
import play.data.validation.*;

@Entity
public class PSU extends Model {
	@Required
	public int energy;
	
	@Required
	public String brand;
	
	@Required
	public String name;
	public PSU(String name) {
    	this.name = name;
	}
}
