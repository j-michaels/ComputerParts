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
	public String maker;
	@Required
	public int numCores;
	public double speed;
	public String socket;
	public int cacheMemory;
	public int wattage;
	public double price;
	public String model;
	
	public CPU(String name, String brand, int cores, double speed) {
		this.name = name;
		this.maker = brand;
		this.numCores = cores;
		this.speed = speed;
	}
}