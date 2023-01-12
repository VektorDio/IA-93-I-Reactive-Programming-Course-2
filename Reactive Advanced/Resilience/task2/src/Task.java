import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;

public class Task {

	public static Publisher<String> fallbackOnError(Flux<String> publisher, String fallback) {
		return Flux.from(publisher).onErrorReturn(fallback);
	}
}