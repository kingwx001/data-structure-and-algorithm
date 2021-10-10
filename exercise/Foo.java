package exercise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo implements Runnable{

	Lock lock = new ReentrantLock();
	// Condition A = lock.newCondition();
	Condition B, C;
	int state;

	public Foo() {
		B = lock.newCondition();
		C = lock.newCondition();
	}

	public void first() throws InterruptedException {
		lock.lock();
		try {
			Thread.sleep(100);
			state = 1;
			// printFirst.run() outputs "first". Do not change or remove this line.
			System.out.println("one");
			B.signal();
		} finally {
			lock.unlock();
		}
	}

	public void second() throws InterruptedException {
		lock.lock();
		try {
			
			B.await();
			state = 2;
			// printSecond.run() outputs "second". Do not change or remove this line.
			System.out.println("two");
			C.signal();
		} finally {
			lock.unlock();
		}
	}

	public void third() throws InterruptedException {
		lock.lock();
		try {
			C.await();
			state = 3;
			// printThird.run() outputs "third". Do not change or remove this line.
			System.out.println("third");
		} finally {
			lock.unlock();
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		Foo foo = new Foo();
		Thread first = new Thread(foo);
		Thread second = new Thread(foo);
		Thread third = new Thread(foo);
		first.start();
		second.start();
		third.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if(state == 0)
				first();
			else if(state == 1)
				second();
			else if(state == 2)
				third();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
