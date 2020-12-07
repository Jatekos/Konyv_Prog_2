package main.subscriber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSubscriber<T> implements Subscriber<T> {
	 protected static final Logger LOGGER = LoggerFactory.getLogger(SumerSubscriber.class);
	 
	private ExecutorService threadPool = Executors.newSingleThreadExecutor();
	
	
	
	
	@Override
	public void onSubscribe(Subscription s) {
		// TODO Auto-generated method stub
		s.request(Long.MAX_VALUE);
	}

	@Override
	public void onNext(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		
	}

}
