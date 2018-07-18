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
		int[] arr = IntStream.range(1, (int)elements).toArray();
		
		Integer[] array = new Integer[arr.length];
		for (int i = 0; i < arr.length && i< maxElementsFromPublisher(); i++) {
			array[i] = arr[i];
		}
		return new ArrayPublisher<Integer>(array );
	}

	@Override
	public Publisher<Integer> createFailedPublisher() {
		// TODO Auto-generated method stub
		return null;
	}
	  @Override
	  public long maxElementsFromPublisher() {
	    return 300;
	  }
	  @Override
	  public long boundedDepthOfOnNextAndRequestRecursion() {
	    return 2;
	  }
}
