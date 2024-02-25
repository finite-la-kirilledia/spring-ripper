package com.finite.screensaver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var context = new AnnotationConfigApplicationContext(ScreensaverConfig.class);
        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(200);
        }
    }
}
