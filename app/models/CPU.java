package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;
import play.*;

@Entity
public class CPU extends Model {
	@ManyToOne
	public Build build;
	
	@Required
	public String name;
	@Required
	public String brand;
	@Required
	public int numCores;
	public double speed;
	
	public CPU(String name, String brand, int cores, double speed) {
		this.name = name;
		this.brand = brand;
		this.numCores = cores;
		this.speed = speed;
	}
	
	
}