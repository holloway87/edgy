package com.hw.edgy;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
    private final Color blueLight;
    private short corners;
    private int radius;
    private double rotateAngle;
    private int offsetX;
    private int offsetY;
    private boolean showWireframe;

    public Shape() {
        blueLight = new Color(134, 159, 223);
        corners = 3;
        radius = 200;
        rotateAngle = 0;
        offsetX = 400;
        offsetY = 300;
        showWireframe = false;
    }

    public void draw(Graphics g) {
        double cornersAngel = 360 / corners;
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];
        int rotateDiffX;
        int rotateDiffY;
        double tmpAngle = rotateAngle;

        xPoints[0] = offsetX;
        yPoints[0] = offsetY;

        g.setColor(blueLight);
        for (int c = 0; c < corners; c++) {
            for (short a = 1; a <= 2; a++) {
                rotateDiffX = (int) (Math.sin(tmpAngle * 2 * Math.PI / 360) * radius);
                rotateDiffY = (int) (Math.cos(tmpAngle * 2 * Math.PI / 360) * radius);
                xPoints[a] = offsetX + rotateDiffX;
                yPoints[a] = offsetY - rotateDiffY;
                if (1 == a) {
                    tmpAngle += cornersAngel;
                }
            }
            if (!showWireframe) {
                g.fillPolygon(xPoints, yPoints, 3);
            }
            g.drawPolygon(xPoints, yPoints, 3);
        }
    }

    public short getCorners() {
        return corners;
    }

    public double getRotateAngle() {
        return rotateAngle;
    }

    public boolean getShowWireframe() {
        return showWireframe;
    }

    public void setCorners(short corners) {
        if (3 > corners) {
            corners = 3;
        } else if (100 < corners) {
            corners = 100;
        }
        this.corners = corners;
    }

    public void setRotateAngle(double rotateAngle) {
        if (0 > rotateAngle) {
            rotateAngle += 360;
        }
        this.rotateAngle = rotateAngle % 360;
    }

    public void setShowWireframe(boolean showWireframe) {
        this.showWireframe = showWireframe;
    }
}
