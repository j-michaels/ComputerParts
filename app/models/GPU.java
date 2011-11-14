package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class GPU extends Model {
    public String name;
    public String requires;
    
}