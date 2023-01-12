import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserActivityUtils {

	public static Mono<Product> findMostExpansivePurchase(Flux<Order> ordersHistory,
			ProductsCatalog productsCatalog) {
		return ordersHistory.flatMapIterable(Order::getProductsIds)
				.map(productsCatalog::findById)
				.reduce((prod, prod2) -> {
					if (prod.getPrice() > prod2.getPrice()) {
						return prod;
					} else {
						return prod2;
					}});
	}
}
