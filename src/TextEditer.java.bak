import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextEditer extends JFrame {

  public static JTextField filepath;
  public static JTextArea textArea;

  public static String readFile(String filepath) {

    try {

      BufferedReader fileReader = new BufferedReader(new FileReader(new File(filepath)));
      String fileContents = "";
      String fileLine = fileReader.readLine();

      while (fileLine != null) {

        fileContents += fileLine + "\n";
        fileLine = fileReader.readLine();

      }

      fileReader.close();
      return fileContents;

    } catch (Exception e) {

      return "";

    }

  }

  public static void writeFile(String filepath, String contents) {

    try {

      BufferedWriter fileWriter = new BufferedWriter(new FileWriter(new File(filepath)));

      fileWriter.write(contents);

      fileWriter.close();

    } catch (Exception e) {}

  }

  public TextEditer(String ogFilepath) {

    setTitle("Text Editer");
    setSize(1028, 818);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    MenuBar menuBar = new MenuBar();
    Menu menu = new Menu("File");
    MenuItem openMenuItem = new MenuItem("Open", new MenuShortcut('O'));
    MenuItem saveMenuItem = new MenuItem("Save", new MenuShortcut('S'));

    openMenuItem.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        textArea.setText(readFile(filepath.getText()));

      }

    });

    saveMenuItem.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        writeFile(filepath.getText(), textArea.getText());

      }

    });

    menu.add(openMenuItem);
    menu.add(saveMenuItem);
    menuBar.add(menu);
    setMenuBar(menuBar);

    JPanel content = new JPanel();
    content.setLayout(null);
    add(content);

    filepath = new JTextField();
    filepath.setBounds(10, 10, 300, 30);
    filepath.setText(ogFilepath);
    content.add(filepath);

    textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setBounds(10, 50, 1008, 698);
    content.add(scrollPane);

    setVisible(true);

  }

  public static void main(String[] args) {

    if (args.length > 0) {

      new TextEditer(args[0]);

    } else {

      new TextEditer("Enter filepath");

    }

  }

}
