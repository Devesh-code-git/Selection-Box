import javax.swing.JFrame;

// Frame class to intialize JPanel
public class Frame extends JFrame{
    public Frame() {
        Panel screen = new Panel(); // New JPanel

        this.setVisible(true);
        this.setTitle("Square");

        this.add(screen);
        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}