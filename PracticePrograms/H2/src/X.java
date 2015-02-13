import java.util.Arrays;
import java.util.Queue;

class MemoryException2 extends Exception {
	private static final long serialVersionUID = 1L;
	private MemoryException2() {}
	MemoryException2(int size, int limit) {
		this();
		System.out.println("Exceeds the maximum limit : " + 
				limit + " size = " + size);
	}
}

class Array<T> {
	int size = 16;
	int count = 0;
	int front = 0;
	int rear = 0;
	T[] a = null;
	int frontclear = size/2;
	final int limit = 100000;

	@SuppressWarnings("unchecked")
	Array() {
		a = (T[]) new Object[this.size];
	}

	@SuppressWarnings("unchecked")
	Array(int _size) {
		if (check2(_size))
			this.size = _size;
		a = (T[]) new Object[this.size];
	}

	private boolean check2(int _size) {
		if (_size < this.frontclear + this.count)
			return false;
		if (_size >= this.limit)
			return false;
		return true;
	}

	private void resize(int _size) throws MemoryException2 {
		if (_size < 0)
			return;
		if (_size < this.count)
			return;
		if (!check2(_size))
			return;
		this.size = _size;	
		@SuppressWarnings("unchecked")
		T[] b = (T[]) new Object[_size];
		for (int i = this.frontclear, j = this.front; i < this.count; i++, j++)
			b[i] = a[j];
		this.front = this.frontclear;
		this.rear = this.front + this.count - 1;
		this.a = null; this.a = b;
	}

	private void readadjust() {
		if (this.front != 0)
			return;
		final int inc = this.frontclear;
		final int nsize = this.size + inc >= this.limit ? this.limit -1 : this.size + inc;
		try {
			resize(nsize);
		} catch (MemoryException2 e) {
			e.printStackTrace();
			return;
		}
	}

	void frontInsert(T t) {
		readadjust();
		this.a[this.front--] = (T) t;
		this.count++;
	}

	void rearInsert(T t) {
		try {
			resize(this.size * 2);
		} catch (MemoryException2 e) {
			e.printStackTrace();
			return;
		}
		this.a[this.rear++] = (T) t; 
	}
	
	void 
}