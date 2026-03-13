import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class Panel extends JPanel implements MouseListener{
    private boolean show = false;
    private int start_x, start_y, end_x, end_y, w, h;

    public static void main(String[] args) {
        new Frame();
    }
    
    public Panel() {
        this.setPreferredSize(new Dimension(800, 800));
        this.setBackground(new Color(34, 34, 34));
        this.setLayout(null);

        addMouseListener(this);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                end_x = e.getX();
                end_y = e.getY();

                repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g);

        if (show) {
            g2D.setColor(new Color(100, 146, 160));
            g2D.setStroke(new BasicStroke(4));

            g2D.drawLine(start_x, start_y, end_x, start_y);
            g2D.drawLine(start_x, start_y, start_x, end_y);
            g2D.drawLine(start_x, end_y, end_x, end_y);
            g2D.drawLine(end_x, start_y, end_x, end_y);

            w = Math.abs(end_x - start_x);
            h = Math.abs(end_y - start_y);

            g2D.setColor(new Color(173, 216, 230));
            if (end_x < start_x) {
                if (end_y < start_y) {
                    g2D.fillRect(end_x, end_y, w, h);
                } else {
                    g2D.fillRect(end_x, start_y, w, h);
                }
            } else {
                if (end_y < start_y) {
                    g2D.fillRect(start_x, end_y, w, h);
                } else {
                    g2D.fillRect(start_x, start_y, w, h);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        start_x = e.getX();
        start_y = e.getY();

        show = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        show = false;

        repaint();
    }
    
}
