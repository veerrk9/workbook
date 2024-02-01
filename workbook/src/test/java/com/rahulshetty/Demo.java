package com.rahulshetty;

public class Demo implements Inter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Demo d = new Demo();
//		d.test1();
		Inter.test();
	}

	@Override
	public void test1() {
		System.out.println("hello");
		
	}
	
	public void test() {
		System.out.println("hello");
		
	}

}
