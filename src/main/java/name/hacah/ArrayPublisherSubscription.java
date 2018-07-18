package name.hacah;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

final class ArrayPublisherSubscription<T> implements Subscription {
	private final Subscriber<? super T> s;
	private final T[] array;

	int readIndex = 0;
	volatile long index;

	AtomicLongFieldUpdater updater = AtomicLongFieldUpdater.newUpdater(ArrayPublisherSubscription.class, "index");
	volatile boolean finish = false;

	ArrayPublisherSubscription(Subscriber<? super T> s, T[] array) {
		this.s = s;
		this.array = array;
	}

	@Override
	public void request(long n) {
//				updater.updateAndGet(this, n);
		for (;!finish && readIndex < array.length;) {
			s.onNext(array[readIndex++]);
		} 
			finish = true;
			s.onComplete();
		

	}

	@Override
	public void cancel() {
		finish = true;

	}
}