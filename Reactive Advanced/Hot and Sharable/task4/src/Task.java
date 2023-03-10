import org.reactivestreams.Publisher;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

public class Task {

	public static Publisher<String> transformToHot2(Flux<String> coldSource) {
		return coldSource.subscribeWith(EmitterProcessor.create());
	}
}