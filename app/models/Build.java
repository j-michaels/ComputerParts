package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.*;
import play.data.validation.*;

@Entity
public class Build extends Model {
	@OneToMany
	public List<GPU> gpus = new ArrayList();
	
	@OneToOne
	public CPU cpu;
	
	@OneToOne
	public Motherboard mobo;
	
	@Required
	public String name;
	
	public Build(String name) {
		this.name = name;
	}
}