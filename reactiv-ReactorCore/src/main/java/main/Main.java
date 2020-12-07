package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ItalicAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dataprovider.DataProvider;
import dataprovider.IntegerData;
import main.subscriber.MeanSubsciber;
import main.subscriber.SumerSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuples;

public class Main {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scheduler scheduler = Schedulers.newElastic("foo");

		List<Integer> asd = new ArrayList<>() ;
		asd.add(0);
		asd.add(1);
		asd.add(2);
		asd.add(3);
		asd.add(4);
		asd.add(5);
		asd.add(6);
		// Flux::creat
		
		DataProvider data = new IntegerData();

		Flux<Integer> flux = Flux.fromIterable(data.datacreator(9)).subscribeOn(scheduler);

		flux.subscribe(new SumerSubscriber());
		flux.subscribe(new MeanSubsciber());

		scheduler.dispose();
//		LOGGER.debug("sart");
//		
//		//Scheduler scheduler = Schedulers.newElastic("foo");
//		Flux<Integer> just = Flux.just(0,1,2,3,4,5,6,7,8,9).subscribeOn(scheduler);
//		just.subscribe(new SumerSubscriber());
//		LOGGER.info("Nem Ragad be");
//		

		// Scheduler scheduler = Schedulers.newElastic("foo");

	}

}
