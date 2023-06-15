package unitins;

 public class StackTinsOutraForma<T> {

	private ArrayTins<T> array = new ArrayTins<T>();

	public void push(T newElement) {
		array.add(0, newElement);
	}

	public T pop() {
		return array.remove(0);
	}

	public int size() {
		return array.size();
	}

	public boolean isEmpty() {
		return array.isEmpty();
	}

}
