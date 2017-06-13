package com.aop;

public class ProxtAop {
	public void before(){
		System.out.println("before:"+System.currentTimeMillis());


	}

	public void after(){
		System.out.println("after:"+System.currentTimeMillis());

	}

}
