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
	public String brand;
	public String name;
	
	public RAM(String name) {
    	this.name = name;
	}
}
