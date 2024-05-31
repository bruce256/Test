package future.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 吕胜 lvheng1
 * @date 2024/5/30
 **/
public class CompletableFutureTest2 {
	
	public static void main(String[] args) {
		CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
			return "hello";
		});
		try {
			System.out.println(stringCompletableFuture.get());
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} catch (ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
}
