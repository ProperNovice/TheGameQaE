package utils;

public class ArrayListImageView<T> extends ArrayList<T> {

	@Override
	public void add(int index, T element) {
		super.add(index, element);
		runDuplicateProtection();
	}

	@Override
	public void addFirst(T element) {
		super.addFirst(element);
		runDuplicateProtection();
	}

	@Override
	public void addLast(T e) {
		super.addLast(e);
		runDuplicateProtection();
	}

	@Override
	public void addAll(ArrayList<T> list) {
		super.addAll(list);
		runDuplicateProtection();
	}

	@Override
	public void addAll(T[] list) {
		super.addAll(list);
		runDuplicateProtection();
	}

	@Override
	public void clear() {
		super.clear();
		runDuplicateProtection();
	}

	@Override
	public void remove(T t) {
		super.remove(t);
		runDuplicateProtection();
	}

	@Override
	public T removeFirst() {

		T t = super.list.remove(0);
		runDuplicateProtection();
		return t;

	}

	@Override
	public T removeLast() {

		T t = super.list.remove(this.list.size() - 1);
		runDuplicateProtection();
		return t;

	}

	@Override
	public T removeRandom() {

		int randomIndex = Random.INSTANCE.getRandomNumber(0, super.list.size() - 1);
		T t = super.list.remove(randomIndex);
		runDuplicateProtection();
		return t;

	}

	@Override
	public void set(int index, T element) {
		super.set(index, element);
		runDuplicateProtection();
	}

	private void runDuplicateProtection() {
		RealTimeDuplicateProtection.INSTANCE.executeDuplicateProtect();
	}

}
