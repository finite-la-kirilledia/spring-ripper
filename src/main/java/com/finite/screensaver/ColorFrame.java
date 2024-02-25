package com.finite.screensaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
public class ColorFrame extends JFrame {

    @Autowired
    private ApplicationContext context;

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        int x = new Random().nextInt(1200);
        int y = new Random().nextInt(800);
        setLocation(x, y);
        getContentPane().setBackground(context.getBean(Color.class));
        repaint();
    }
}
