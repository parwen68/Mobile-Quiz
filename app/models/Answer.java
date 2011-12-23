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

    public Answer(String name, String question, String answer) {
		this.name = name;
		this.question = Long.parseLong(question);
		this.answer = Long.parseLong(answer);
	}
    
}
