package com.test;


import java.lang.reflect.Proxy;

import com.aop.ProxtAop;
import com.proxy.BlogServiceProxy;
import com.service.IBlogService;
import com.service.impl.BlogService;

public class TestDYProxy {
	
	public static void main(String[] args) {
		
		IBlogService ibs = new BlogService();
		BlogServiceProxy bsp = new BlogServiceProxy(ibs, new ProxtAop());
		
		IBlogService ibsProxy = (IBlogService)Proxy.newProxyInstance(bsp.getClass().getClassLoader(), ibs.getClass().getInterfaces(), bsp);
		ibsProxy.insertBlog(null);
	}

}
