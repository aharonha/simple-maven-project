package name.hacah;

import java.util.stream.IntStream;

import org.reactivestreams.Publisher;
import org.reactivestreams.tck.PublisherVerification;
import org.reactivestreams.tck.TestEnvironment;

public class ArrayPublisherTest extends PublisherVerification<Integer>

{
	public ArrayPublisherTest() {
		super(new TestEnvironment());
	}

	@Override
	public Publisher<Integer> createPublisher(long elements) {
		Integer[] arr = (Integer[]) IntStream.range(1, Integer.max(Integer.MAX_VALUE, ((int) elements))).boxed()
				.toArray();
		return new ArrayPublisher<Integer>(arr);
	}

	@Override
	public Publisher<Integer> createFailedPublisher() {
		// TODO Auto-generated method stub
		return null;
	}

}
