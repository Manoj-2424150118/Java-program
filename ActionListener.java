import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileCreator extends Frame implements ActionListener {
    TextField rollField, nameField, marksField;
    Button enterButton, doneButton;
    FileWriter fw;

    FileCreator() {
        setLayout(new FlowLayout());

        add(new Label("Roll Number:"));
        rollField = new TextField(20);
        add(rollField);

        add(new Label("Student Name:"));
        nameField = new TextField(20);
        add(nameField);

        add(new Label("Marks:"));
        marksField = new TextField(20);
        add(marksField);

        enterButton = new Button("Enter");
        doneButton = new Button("Done");
        add(enterButton);
        add(doneButton);

        enterButton.addActionListener(this);
        doneButton.addActionListener(this);

        try {
            fw = new FileWriter("student.txt", true);
        } catch (IOException e) {
            System.out.println(e);
        }

        setSize(300, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == enterButton) {
                String data = rollField.getText() + " " + nameField.getText() + " " + marksField.getText() + "\n";
                fw.write(data);
                rollField.setText("");
                nameField.setText("");
                marksField.setText("");
            } else if (e.getSource() == doneButton) {
                fw.close();
                System.exit(0);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        new FileCreator();
    }
}
