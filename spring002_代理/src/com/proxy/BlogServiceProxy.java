package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.aop.ProxtAop;

public class BlogServiceProxy implements InvocationHandler{
	private ProxtAop ProxtAop;
	//被代理的对象
	private Object obj;
	
	//可以通过构造来设置obj的值
	public BlogServiceProxy(Object obj,ProxtAop ProxtAop ) {
		super();
		this.obj = obj;
		this.ProxtAop = ProxtAop;
	}

	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
//		System.out.println("before以前的操作");
		ProxtAop.before();
		Object result = method.invoke(obj, args);
		ProxtAop.after();
//		System.out.println("after以后的操作");
		
		return result;
	}

	
}
