package com.finite.screensaver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "com.finite.screensaver")
public class ScreensaverConfig {

    @Bean
    public Color color() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r, g, b);
    }
}
