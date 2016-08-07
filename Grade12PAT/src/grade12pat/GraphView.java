/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author yaseen
 */
public class GraphView extends javax.swing.JFrame {
    private List<RcdPatientReadings> readings;
    private String title;
    /**
     * Creates new form GraphView
     */
    public GraphView(List<RcdPatientReadings> readings, String title) {
        initComponents();
        this.readings = readings;
        this.title = title;
    }
    
    class GraphPanel extends JPanel {
        int padding = 10;
        int pointRadius = 5;
        int numXticks = 10;
        int numYticks = 10;
        double minY;
        double maxY;
        double minX;
        double maxX;
        
        @Override
        protected void paintComponent(Graphics g) {
            int height = this.getHeight();
            int width = this.getWidth();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);
            
            drawTitle(g);
            drawBorder(g, width - 4 * padding, height - 4 * padding);
           
            g.translate(2 * padding, 2 * padding);
            drawPoints(g, width - 4 * padding, height - 4 * padding);
            g.translate(-2 * padding, -2 * padding);
        }
        
        private void drawBorder(Graphics g, int coordW, int coordH) {
            int height = this.getHeight();
            int width = this.getWidth();
            g.setColor(Color.BLACK);
            g.drawRect(padding, padding, width - 2 * padding, height - 2 * padding);
            double diff = oneSignificantDigit((maxY - minY) / numYticks);
            double start = oneSignificantDigit(minY);
            for (int i = 0; i < numYticks; ++i) {
                double yValue = i * diff + start;
                int y = coordH - (int) readingToY(yValue, coordH);
                g.drawLine(padding - 2, y, padding + 2, y);
                g.drawString(yValue + "", padding, y);
            }
        }
        
        private double oneSignificantDigit(double a) {
            String base10 = a + "";
            if (base10.charAt(0) == '0') {
                base10 = base10.substring(2);
            }
            double exp = Math.floor(Math.log10(a));
            double firstDigit = base10.charAt(0) - '0';
            return firstDigit * Math.pow(10, exp);
        }
        
        private void drawTitle(Graphics g) {
            g.setColor(Color.BLACK);
            g.drawString("Graph showing " + title, padding * 2, 2 * padding + g.getFontMetrics().getHeight());
        }
       
        private void drawPoints(Graphics g, int width, int height) {
            List<Point> coords = computeCoordinates(width, height);
            Point last = null;
            for (int i = 0; i < coords.size(); ++i) {
                Point c = coords.get(i);
                int cx = (int) c.getX();
                int cy = height - (int) c.getY();
                g.fillOval(cx - pointRadius, cy - pointRadius,  2 * pointRadius,  2 * pointRadius);
                if (last != null) {
                    int lx = (int) last.getX();
                    int ly = height - (int) last.getY();
                    g.drawLine(lx, ly, cx, cy);
                }
                last = c;
            }
        }
        
        private List<Point> computeCoordinates(int width, int height) {
            ArrayList<RcdPatientReadings> readings = new ArrayList<RcdPatientReadings>(GraphView.this.readings);
            List<Point> coords = new ArrayList<Point>();
            int nr = readings.size();
            
            readings.sort(new Comparator<RcdPatientReadings>() {
                @Override
                public int compare(RcdPatientReadings a, RcdPatientReadings b) {
                    return a.getTime().compareTo(b.getTime());
                }
            });
            minX = readings.get(0).getTime().getTime();
            maxX = readings.get(nr - 1).getTime().getTime();
            minY = 0;
            maxY = 0;
            
            for (int i = 0; i < nr; ++i) {
                double time = readings.get(i).getTime().getTime();
                coords.add(new Point(timeToX(time, width), 0));
                double reading = readings.get(i).getReading();
                minY = Math.min(reading, minY);
                maxY = Math.max(reading, maxY);
            }
            for (int i = 0; i < nr; ++i) {
                double reading = readings.get(i).getReading();
                coords.get(i).y = readingToY(reading, height);
            }                 
            return coords;
        }
        
        private int readingToY(double reading, int height) {
            return (int)((reading - minY) / (maxY - minY) * height);
        }
        
        private int timeToX(double time, int width) {
            return (int)((time - minX) / (maxX - minX) * width);
        }
    }
    /** 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGraph = new GraphPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pnlGraphLayout = new javax.swing.GroupLayout(pnlGraph);
        pnlGraph.setLayout(pnlGraphLayout);
        pnlGraphLayout.setHorizontalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );
        pnlGraphLayout.setVerticalGroup(
            pnlGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlGraph;
    // End of variables declaration//GEN-END:variables
}
