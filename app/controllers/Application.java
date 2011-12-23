package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Answer;
import models.Question;
import play.mvc.Controller;
import play.mvc.Scope.Session;

public class Application extends Controller {

    public static void index() {
    	List<Question> questions = Question.findAll();
    	render(questions);
    }

    public static void start(String name) {
		session.put("name", name);
		renderJSON("{\"name\": \" "+ name +"\"}");
	}
    
    public static void submit(Map<String,String> answer) {
    	String name = session.get("name");
    	
    	List<Question> questions = Question.find("order by id").fetch();
		for(String key : answer.keySet()) {
			System.out.println(key);
			Answer a = new Answer(name, key, answer.get(key));
			a.save();
		}
		
		int correctAnswers = 0;
		for(Question q : questions) {
			String a = answer.get(q.getId().toString());
			if(a.equals(Integer.toString(q.correctAlternative))) {
				correctAnswers++;
			}
		}	
		renderJSON("{\"correctanswers\": " + correctAnswers + "}");
	}    
}