package com.hw.edgy;

import java.awt.*;

public class Shape {
    private final Color blueLight;
    private short corners;
    private int radius;
    private int offsetX;
    private int offsetY;

    public Shape() {
        blueLight = new Color(134, 159, 223);
        corners = 3;
        radius = 100;
        offsetX = 400;
        offsetY = 300;
    }

    public void draw(Graphics g) {
        double cornersAngel = 360 / corners;
        double ang = (180 - cornersAngel) / 2;
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        double sideLength = (Math.cos(ang * 2 * Math.PI / 360) * radius) * 2;
        int diffX = (int) (sideLength / 2);
        int diffY = (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(diffX, 2));

        xPoints[0] = offsetX;
        yPoints[0] = offsetY;
        xPoints[1] = offsetX;
        yPoints[1] = offsetY - radius;
        xPoints[2] = offsetX + diffX;
        yPoints[2] = offsetY + diffY;

        g.setColor(blueLight);
        g.fillPolygon(xPoints, yPoints, 3);

        xPoints[1] = xPoints[2];
        yPoints[1] = yPoints[2];
        xPoints[2] = offsetX - diffX;
        yPoints[2] = offsetY + diffY;
        g.fillPolygon(xPoints, yPoints, 3);

        xPoints[1] = offsetX;
        yPoints[1] = offsetY - radius;
        g.fillPolygon(xPoints, yPoints, 3);
    }
}
