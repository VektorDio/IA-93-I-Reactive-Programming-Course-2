import reactor.core.publisher.Flux;

import java.util.Arrays;

public class Task {

	public static Flux<Character> createSequence(Flux<String> stringFlux) {
		return stringFlux.flatMap(word -> Flux.fromArray(word.split(""))).map(letter -> letter.charAt(0));
	}
}