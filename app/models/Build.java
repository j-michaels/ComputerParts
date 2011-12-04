package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.*;
import play.data.validation.*;

@Entity
public class Build extends Model {
	@OneToOne
	public GPU gpu; 
	
	@OneToOne
	public CPU cpu;
	
	@OneToOne
	public RAM ram;
	
	@OneToOne
	public Motherboard mb;
	
	@OneToOne
	public PSU psu;
	
	@OneToOne
	public HD hd;
	
	@Required
	public String name;

	public int numRam;
	
	public Build(String name) {
		this.name = name;
	}
}