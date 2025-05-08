import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyStatusFrame extends JFrame implements KeyListener {
    String msg = "";

    public KeyStatusFrame() {
        setTitle("Key Status");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
    }

    public void keyPressed(KeyEvent ke) {
        msg = "Key Down: " + ke.getKeyChar();
        repaint();
    }

    public void keyReleased(KeyEvent ke) {
        msg = "Key Released: " + ke.getKeyChar();
        repaint();
    }

    public void keyTyped(KeyEvent ke) {
        msg = "Key Typed: " + ke.getKeyChar();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(msg, 100, 100);
    }

    public static void main(String[] args) {
        new KeyStatusFrame();
    }
}
