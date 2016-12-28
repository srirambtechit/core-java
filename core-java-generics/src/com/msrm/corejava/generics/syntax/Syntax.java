package com.msrm.corejava.generics.syntax;

import java.io.Serializable;
import java.util.ArrayList;

// Generic on Class level
public class Syntax<T> {

	// Generic on instance variables
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}

	// Generic on static methods
	public static <E> E process(E e) {
		// element e is an Object type
		E t = e;
		// Can able to access all public methods of
		// Object class
		System.out.println(t.equals(e));
		System.out.println(t.toString());
		return e;
	}

	// ---------------------
	// generic constructor
	class MyClass<X> {
		MyClass() {
			System.out.println("Normal constructor");
		}

		<Y> MyClass(Y y) {
			System.out.println("Generic constructor");
		}
	}

	@SuppressWarnings("unused")
	public void constructorUsage() {
		MyClass<Integer> myCls = new MyClass<>();
		MyClass<String> strCls = new MyClass<>("test");
	}

	// Generic on instance methods
	public <K, V> void mapProcessing(K k, V v) {
		System.out.println(k + " : " + k.getClass());
		System.out.println(v + " : " + v.getClass());
	}

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {
		// Invoking generic static method
		Integer p = Syntax.<Integer>process(4);

		Syntax<String> obj = new Syntax<>();
		obj.mapProcessing("three", 3);
	}
	// ---------------------
	
	// ---------------------
	// ------- Upper bound types
	// ------- Single bound
	// N is a type of Number or its child type
	public <N extends Number> void concat(N n1, N n2) {
		String result = n1.toString() + n2.toString();
		System.out.println(result);
	}

	// ------- Upper bound types
	// ------- Single bound
	// interface also can referred
	public <J extends Runnable> void doJob(J j) {
	}
	// ---------------------
	
	// ---------------------
	// ------- Upper bound types
	// ------- Multi bound
	class A {
	}

	interface B {
	}

	interface C {
	}

	// Here bound first type should be a class
	// rest should be interface
	class D<S extends A & B & C> {
	}
	// ---------------------
	
	
	// ---------------------
	// Type inference
	public static <T> T pick(T t1, T t2) {
		return t2;
	}

	@SuppressWarnings("unused")
	public static void testPick() {
		// Example 1: Here, first parameter is String, second one is ArrayList
		// Common parent for both of the type is Serializable
		// which will inferred by Java compiler
		Serializable objectPicker = pick("4", new ArrayList<Integer>());

		// Example 2: Here, first parameter is Integer, second one is Double
		// common parent for both the type is Number
		// which will be inferred by Java compiler
		Number numberPicker = pick(4, 23.3);
	}
	// ---------------------

}
