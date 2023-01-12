import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.util.context.Context;

public class Task {

	public static Flux<String> provideCorrectContext(Publisher<String> sourceA,
			Context contextA,
			Publisher<String> sourceB,
			Context contextB) {
		Flux<String> flux1 = Flux.from(sourceA).subscriberContext(contextA);
		Flux<String> flux2 = Flux.from(sourceB).subscriberContext(contextB);
		return Flux.merge(flux1, flux2);
	}
}