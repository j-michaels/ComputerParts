package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.*;

@Entity
public class GPU extends Model {
	public String name;
    public String requires;
    
    public GPU(String name) {
    	this.name = name;
	}
}