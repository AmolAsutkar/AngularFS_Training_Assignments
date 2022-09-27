package com.d3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/d3/config.xml");
		SpElEx obj =  context.getBean("spElEx",SpElEx.class);
		System.out.println(obj);
		
		
		SpelExpressionParser  expr = new SpelExpressionParser();
		Expression expression = expr.parseExpression("30+40");
		System.out.println(expression.getValue());

	}

}
