package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Answer extends Model {
    public String name;
    public Long question;
    public Long answer;

    public Answer(String name, Long question, Long answer) {
		this.name = name;
		this.question = question;
		this.answer = answer;
	}
    
}
