package models;

import play.*;
import play.data.validation.MaxSize;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Question extends Model {
	@MaxSize(500)
    public String text;
    public String alternative1;
    public String alternative2;
    public String alternative3;
    public int correctAlternative;
}
