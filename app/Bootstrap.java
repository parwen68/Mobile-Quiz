import models.Question;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Bootstrap extends Job {
	@Override
	public void doJob() throws Exception {
		if(Question.count() == 0) {
			Fixtures.loadModels("init-data.yml");
		}
	}
}
