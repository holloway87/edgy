package com.hw.edgy;

import javax.swing.*;
import java.awt.*;

public class Edgy extends JPanel implements Runnable {

    private final Font fontDefault;
    private long fps = 0;
    private JFrame frame;
    private final InputManager input;
    private final Game game;
    private long timeLast = 0;

    public Edgy() {
        fontDefault = new Font("sans-serif", Font.PLAIN, 12);
        input = new InputManager();

        initWindow(800, 600);

        game = new Game();

        timeLast = System.nanoTime();
        Thread th = new Thread(this);
        th.start();
    }

    private void calcTimeDelta()
    {
        long timeDelta = System.nanoTime() - timeLast;
        timeLast = System.nanoTime();
        fps = ((long) 1e9) / timeDelta;
    }

    private void checkKeys() {
        game.checkKeys(input);
    }

    private void initWindow(int w, int h) {
        this.setPreferredSize(new Dimension(w, h));
        frame = new JFrame("edgy");
        frame.setLocation(100, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(this);
        frame.addKeyListener(input);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Edgy();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(new Color(46, 52, 54));
        g.fillRect(0, 0, getWidth(), getHeight());

        game.draw(g);

        g.setFont(fontDefault);
        g.setColor(Color.white);
        g.drawString("FPS: " + Long.toString(fps), 20, 20);
    }

    @Override
    public void run()
    {
        while (frame.isVisible()) {
            calcTimeDelta();
            checkKeys();

            repaint();

            try
            {
                Thread.sleep(15);
            }
            catch (InterruptedException e) {
                System.out.println("error: thread sleep failed");
            }
        }
    }
}
