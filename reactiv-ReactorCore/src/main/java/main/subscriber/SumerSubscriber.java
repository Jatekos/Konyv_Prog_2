package main.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SumerSubscriber extends AbstractSubscriber<Integer> {

	 private static final Logger LOGGER = LoggerFactory.getLogger(SumerSubscriber.class);
	
	Integer sum =0 ;
	
	
	
	@Override
	public void onSubscribe(Subscription s) {
		// TODO Auto-generated method stub
		s.request(Long.MAX_VALUE);
		
	}

	@Override
	public void onNext(Integer t) {
		// TODO Auto-generated method stub
		
		sum+=t;
		//System.out.println(sum);
		LOGGER.info(sum.toString());
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		
		return ;
		
		
	}

}
