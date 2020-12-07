package main.subscriber;

public class MeanSubsciber extends AbstractSubscriber<Integer> {

	Integer sum = 0;
	Integer count = 0;

	@Override
	public void onNext(Integer t) {
		// TODO Auto-generated method stub
		sum += t;
		count++;
		LOGGER.info("mean: {}", (double) (sum / count));

	}
}
