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
	public String maker;
	@Required
    public String provides;
    
	public String cpuSocket;
	public String fsb;
	public String ram;
	public int maxRAM;
	public String videoCardInterface;
	public int videoCardSlots;
	public int power;
	public double price;
	public String model;
	public String hdInterface;
    public String other;
    
    public Motherboard(String name) {
    	this.name = name;
	}
}