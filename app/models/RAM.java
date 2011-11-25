package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.*;

@Entity
public class RAM extends Model {
	public int speed;
	public String model;
	public String brand;
}
