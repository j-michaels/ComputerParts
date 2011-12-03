package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class Motherboard extends Model {
	@Required
    public String name;
	@Required
	public String brand;
	@Required
    public String provides;
    
    public String other;
    
    public Motherboard(String name) {
    	this.name = name;
	}
}