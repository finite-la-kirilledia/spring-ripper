package com.finite.screensaver;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
public abstract class ColorFrame extends JFrame {

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    protected abstract Color getColor();

    public void showOnRandomPlace() {
        int x = new Random().nextInt(1200);
        int y = new Random().nextInt(800);
        setLocation(x, y);
        getContentPane().setBackground(getColor());
        repaint();
    }
}
