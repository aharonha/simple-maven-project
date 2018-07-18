package name.hacah;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class ArrayPublisher<T> implements Publisher<T> {

	
	private T[] array;
	int readIndex=0;

	public ArrayPublisher(T[] array) {
		this.array = array;
	}

	@Override
	public void subscribe(Subscriber<? super T> s) {
		s.onNext(array[readIndex++]);
		
	}

}
