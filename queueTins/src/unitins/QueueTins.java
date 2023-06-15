package unitins;

public class QueueTins<T> {

	private ArrayTins<T> array = new ArrayTins<T>();

	public void enqueue(T newElement) {
		array.add(0, newElement);
	}

	public T dequeue() {
		return array.remove(array.size() - 1);
	}

	public int size() {
		return array.size();
	}

	public boolean isEmpty() {
		return array.isEmpty();
	}

}
