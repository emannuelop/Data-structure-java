package unitins;

public class StackTins<T> extends ArrayTins<T> {

	public void push(T newElement) {

		this.add(0, newElement);

	}

	public T pop() {

		return this.remove(0);

	}

}
