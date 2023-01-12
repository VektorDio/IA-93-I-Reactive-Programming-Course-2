import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.function.TupleUtils;
import reactor.util.function.Tuple3;

public class Task {

	public static Publisher<String> zipSeveralSources(Publisher<String> prefixPublisher,
			Publisher<String> wordPublisher,
			Publisher<String> suffixPublisher) {
		return Flux.zip(prefixPublisher, wordPublisher, suffixPublisher)
				.map(tuple -> tuple.getT1() + tuple.getT2() + tuple.getT3());
	}
}