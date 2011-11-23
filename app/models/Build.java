package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.*;


@Entity
public class Build extends Model {
	public ArrayList<GPU> gpus;
	
	public Motherboard mobo;
	public String name;
	
	public Build(String name) {
		this.name = name;
	}
}