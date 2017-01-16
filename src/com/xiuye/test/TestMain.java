package com.xiuye.test;

import java.lang.reflect.Method;

public class TestMain {

	static class A{
		public void f(String k,int i){
			System.out.println("OK");
		}
		public void f1(){
			
		}
		public void f2(String k,int i){
			
		}
	}
	
	public static void main(String[] args) {
		
		Object o = new A();
		Method [] ms = o.getClass().getDeclaredMethods();
		System.out.println(ms.length);
		for(Method m : ms){
			System.out.println(m.getName());
			System.out.println(m.getDefaultValue());
			System.out.println(m.getModifiers());
			System.out.println(m.getAnnotations());
			System.out.println(m.getParameterTypes().length);
			System.out.println(m.getDeclaringClass());
//			System.out.println(m.getGenericParameterTypes()[0]);
		}
//		System.out.println("================");
//		ms = o.getClass().getMethods();
//		System.out.println(ms.length);
//		for(Method m : ms){
//			System.out.println(m.getName());
//		}
		
	}

}
