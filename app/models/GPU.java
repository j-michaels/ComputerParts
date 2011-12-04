package models;

import java.util.*;
import javax.persistence.*;
import play.data.validation.*;
import play.db.jpa.*;
import play.*;


@Entity
public class GPU extends Model {
	@ManyToOne
	public Build build;
	
	public String name;
	public String maker;
    public String requires;
    public int vram;
    public String model;
    public int wattage;
    public double price;
    public String intrface;
    
    
    public GPU(String name) {
    	this.name = name;
	}
}