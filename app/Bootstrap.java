import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job {
	public void doJob() {
		if (Build.count() == 0) {
			System.out.println("Attempting to load initial data.");
			Fixtures.loadModels("initial-data.yml");
		}
	}
}