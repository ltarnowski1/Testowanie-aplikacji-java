import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;

public class RunJBehaveSteps {
	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("JBehaveSteps.story");
	
	public static void main(String[] args) {
		embedder.candidateSteps().add(new JBehaveSteps());
		embedder.runStoriesAsPaths(storyPaths);
	}
}