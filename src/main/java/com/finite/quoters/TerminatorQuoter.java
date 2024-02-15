package com.finite.quoters;

import com.finite.injectRandomInt.InjectRandomInt;
import com.finite.postProxy.PostProxy;
import com.finite.profiling.Profiling;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {

    private final String quote;

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    public TerminatorQuoter(String quote) {
        System.out.println("Constructor");
        this.quote = quote;
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");
    }

    @PostProxy
    @Override
    public void sayQuote() {
        System.out.println("PostProxy");
        for (int i = 0; i < repeat; i++) {
            System.out.println(quote);
        }
    }
}
