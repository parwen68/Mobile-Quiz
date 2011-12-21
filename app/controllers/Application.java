package controllers;

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
		for(String key : answer.keySet()) {
			Answer a = new Answer(name, Long.parseLong(key), Long.parseLong(answer.get(key)));
			a.save();
		}
	}
}