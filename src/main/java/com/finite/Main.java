package com.finite;

import com.finite.quoters.Quoter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("context.xml");

        Quoter quoter = context.getBean(Quoter.class);
        quoter.sayQuote();
    }
}
