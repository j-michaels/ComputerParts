package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.*;

@Entity
public class CPU extends Model {
	public String name;
	public String brand;
	public int numCores;
	public double speed;
	
	public CPU(String name, String brand, int cores, double speed) {
		this.name = name;
		this.brand = brand;
		this.numCores = cores;
		this.speed = speed;
	}
}
