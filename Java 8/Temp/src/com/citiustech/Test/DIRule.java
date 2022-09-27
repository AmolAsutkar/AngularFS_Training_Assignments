package com.citiustech.Test;

import java.lang.reflect.Field;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class DIRule implements MethodRule{

	@Override
	public Statement apply(Statement arg0, FrameworkMethod arg1, Object arg2) {
		for(Field f:testobj.getclaass().getDeclaredFields()) {
			if(f.isAnnotationPresent(DI.class)) {
				try {
					f.a
				}
			}
		
		
		try {
			base.evaluate();
			
		}
		catch(Throwable e){
			e.printStackTrace();
			
		}
	}

}
