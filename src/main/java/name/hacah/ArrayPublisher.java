package name.hacah;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class ArrayPublisher<T> implements Publisher<T> {

	private T[] array;

	public ArrayPublisher(T[] array) {
		this.array = array;
	}

	@Override
	public void subscribe(Subscriber<? super T> s) {
		ArrayPublisherSubscription subscription = new ArrayPublisherSubscription(s, array);
		s.onSubscribe(subscription);

	}

}
