// package for program
package ZEdit;

// import needed libs
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

// class which extends JFrame to create window
public class ZEdit extends JFrame {

  public static JTextArea text;
  public static JTextField filepath;

  public ZEdit() {

    // sets up basic window
    setTitle("ZEdit");
    setSize(768, 798);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // creates panel to add components on
    JPanel panel = new JPanel();
    panel.setLayout(null);
    add(panel);

    // adds the text editer
    text = new JTextArea();
    JScrollPane scroll = new JScrollPane(text);
    text.setMargin(new Insets(5, 5, 0, 0));
    text.setBackground(new Color(0, 43, 54));
    text.setForeground(new Color(131, 148, 150));
    text.setCaretColor(new Color(131, 148, 150));
    text.setFont(new Font("monospace", 0, 14));
    scroll.setBounds(0, 0, 768, 728);
    panel.add(scroll);

    // adds the save button
    JButton save = new JButton("Save");
    save.setBounds(20, 738, 100, 25);
    save.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getModifiers() == 16)
              write(filepath.getText());
        }
    });
    panel.add(save);

    // adds an open button
    JButton open = new JButton("Open");
    open.setBounds(140, 738, 100, 25);
    open.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getModifiers() == 16)
              read(filepath.getText());
        }
    });
    panel.add(open);

    // adds the text field to enter file path
    filepath = new JTextField();
    filepath.setText("Filepath");
    filepath.setBounds(260, 738, 150, 25);
    panel.add(filepath);

    // shows the window
    setVisible(true);

  }

  public static void read(String file) {

    // reads in file and puts it in editer
    try {
      BufferedReader read = new BufferedReader(new FileReader(new File(file)));
      String line;
      while ((line = read.readLine()) != null)
        text.append(line + "\n");
      read.close();

    } catch (Exception er) {}

  }

  public static void write(String file) {

    try {
      BufferedWriter scan = new BufferedWriter(new FileWriter(file));
      scan.write(text.getText());
      scan.close();
    } catch (Exception er) {}

  }

  public static void main(String[] args) {

    // creates a new text editer
    new ZEdit();

  }

}
