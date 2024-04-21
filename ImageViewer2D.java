package java01;

import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.BorderLayout;

import java01.*;



class ImageViewer2D extends JFrame{
  public static void main(String args[]){
    ImageViewer2D frame = new ImageViewer2D("MyTitle");
    frame.setVisible(true);
  }

  ImageViewer2D(String title){
    setTitle(title);
    setBounds(100, 100, 600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ImageIcon icon1 = new ImageIcon("./cat.jpg");
    ImageIcon icon2 = new ImageIcon("./ship.jpg");

    JLabel label1 = new JLabel(icon1);

    JLabel label2 = new JLabel();
    label2.setIcon(icon2);

    JPanel p = new JPanel();
    p.add(label1);
    p.add(label2);

    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.CENTER);
  }
}
