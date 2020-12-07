package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import main.subscriber.SumerSubscriber;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;


public class TestMain {

	// https://www.baeldung.com/reactor-core

	@Test
	public void TestSomting() {
		Flux<Integer> just = Flux.just(1, 2, 3, 4);
		Mono<Integer> justMono = Mono.just(1);

		List<Integer> elements = new ArrayList<>();
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		Flux.just(1, 2, 3, 4).log().subscribe(elements::add);

		assertEquals(expected, elements);

	}

	@Test
	public void TestReactorCore52() {

		List<Integer> elements = new ArrayList<>();
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);

		Flux.just(1, 2, 3, 4).log().subscribe(new Subscriber<Integer>() {
			
			private Integer sum=0;
			
			@Override
			public void onSubscribe(Subscription s) {
				s.request(Long.MAX_VALUE);
			}

			@Override
			public void onNext(Integer integer) {
				elements.add(integer);
				sum+=integer;
				System.err.println(sum);
			}

			@Override
			public void onError(Throwable t) {
			}

			@Override
			public void onComplete() {
			}

		});

		assertEquals(expected, elements);

	}

	@Test
	public void TestReactorCore6() {

		List<Integer> elements = new ArrayList<>();
		List<Integer> expected = new ArrayList<>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);

		Flux.just(1, 2, 3, 4).log().subscribe(new Subscriber<Integer>() {
			private Subscription s;
			int onNextAmount;

			@Override
			public void onSubscribe(Subscription s) {
				this.s = s;
				s.request(2);
			}

			@Override
			public void onNext(Integer integer) {
				elements.add(integer);
				onNextAmount++;
				if (onNextAmount % 2 == 0) {
					s.request(2);
				}
			}

			@Override
			public void onError(Throwable t) {
			}

			@Override
			public void onComplete() {
			}
		});

		assertEquals(expected, elements);

	}

	@Test
	public void TestReactorCore71() {

		List<Integer> elements = new ArrayList<>();
		List<Integer> expected = new ArrayList<>();
		expected.add(1*2);
		expected.add(2*2);
		expected.add(3*2);
		expected.add(4*2);

		Flux.just(1, 2, 3, 4).log().map(i -> i * 2).subscribe(elements::add);
		
		assertEquals(expected, elements);

	}
	
	@Test
	public void TestReactorCore72() {
		List<String> elements = new ArrayList<>();
		List<Integer> expected = new ArrayList<>();
		expected.add(1*2);
		expected.add(2*2);
		expected.add(3*2);
		expected.add(4*2);
		
		Flux.just(1, 2, 3, 4)
		  .log()
		  .map(i -> i * 2)
		  .zipWith(Flux.range(0, Integer.MAX_VALUE).log(), 
		    (one, two) -> String.format("First Flux: %d, Second Flux: %d", one, two))
		  .subscribe(elements::add);

		System.out.println(elements);
	
	}
	
	@Test
	public void TestReactorCore81() {
		ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
		    while(true) {
		        fluxSink.next(System.currentTimeMillis());
		    }
		})
		  .publish();
		
		publish.subscribe(System.out::println);        
		publish.subscribe(System.err::println);
		publish.connect();
	}
	
	@Test
	public void TestReactorCore82() {
		ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
		    while(true) {
		        fluxSink.next(System.currentTimeMillis());
		    }
		})
		  .sample(Duration.ofSeconds(2))
		  .publish();
		
		publish.subscribe(System.out::println);        
		publish.subscribe(System.err::println);
		publish.connect();
	}
	
	@Test
	public void TestReactorCore9() {
		List<Integer> elements = new ArrayList<>();
		
		Flux.just(1, 2, 3, 4)
		  .log()
		  .map(i -> i * 2) 
		  .subscribeOn(Schedulers.parallel())
		  .subscribe(elements::add);
		
		System.out.println(elements);
	}
	@Test
	public void TestSomtinIDKwhatIsIt() {
		Scheduler scheduler = Schedulers.newElastic("foo");

		Flux<Integer> flux = Flux.just(1, 2)
		    .subscribeOn(scheduler);

		flux.subscribe(i -> System.out.println(Thread.currentThread().getName()));
		flux.subscribe(i -> System.out.println(Thread.currentThread().getName()));
		flux.subscribe(new SumerSubscriber());
	}
}
