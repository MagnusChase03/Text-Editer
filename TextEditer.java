// import needed libs
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

// class which extends JFrame to create window
public class TextEditer extends JFrame {

  public TextEditer(String file) {

    // sets up basic window
    setTitle("Text Editer");
    setSize(768, 798);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // creates panel to add components on
    JPanel panel = new JPanel();
    panel.setLayout(null);
    add(panel);

    // adds the text editer
    JTextArea text = new JTextArea();
    JScrollPane scroll = new JScrollPane(text);
    text.setMargin(new Insets(5, 5, 0, 0));
    text.setBackground(new Color(0, 43, 54));
    text.setForeground(new Color(131, 148, 150));
    text.setCaretColor(new Color(131, 148, 150));
    scroll.setBounds(0, 0, 768, 728);
    panel.add(scroll);

    // reads in file and puts it in editer
    try {
      BufferedReader read = new BufferedReader(new FileReader(new File(file)));
      String line;
      while ((line = read.readLine()) != null)
        text.append(line + "\n");
      read.close();
        
    } catch (Exception er) {}

    // adds the save button
    JButton save = new JButton("Save to " + file);
    save.setBounds(20, 738, 200, 25);
    save.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getModifiers() == 16) {
                try {
                  BufferedWriter scan = new BufferedWriter(new FileWriter(file));
                  scan.write(text.getText());
                  scan.close();
                } catch (Exception er) {}
            }
        }
    });
    panel.add(save);

    // shows the window
    setVisible(true);

  }

  public static void main(String[] args) {

    // creates the text editer with where to save file
    if (args.length > 0)
      new TextEditer(args[0]);

  }

}
