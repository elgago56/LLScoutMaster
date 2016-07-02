package com.spring.test.runner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.test.TestBean;

public class RunSpring {
	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");

		TestBean tb = (TestBean) ac.getBean("testBean");

		System.out.println(tb.getMessage());

		// required if destroy method is to be called!
		ac.registerShutdownHook();

	}
}
