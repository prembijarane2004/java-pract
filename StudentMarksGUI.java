import java.awt.*;
import java.awt.event.*;

class StudentMarksGUI extends Frame implements ActionListener {
    Label l1, l2, l3, l4;
    TextField t1, t2, t3;
    Button b;

    StudentMarksGUI() {
        setTitle("Student Marks Entry");
        setSize(300, 300);
        setLayout(new FlowLayout());

        l1 = new Label("Enter Marks for Subject 1:");
        t1 = new TextField(10);
        l2 = new Label("Enter Marks for Subject 2:");
        t2 = new TextField(10);
        l3 = new Label("Enter Marks for Subject 3:");
        t3 = new TextField(10);

        b = new Button("Show Result");
        b.addActionListener(this);

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(b);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int m1 = Integer.parseInt(t1.getText());
        int m2 = Integer.parseInt(t2.getText());
        int m3 = Integer.parseInt(t3.getText());

        int total = m1 + m2 + m3;
        float avg = total / 3.0f;
        String result = (m1 >= 35 && m2 >= 35 && m3 >= 35) ? "Pass" : "Fail";

        new ResultWindow(total, avg, result);
    }

    public static void main(String[] args) {
        new StudentMarksGUI();
    }
}

class ResultWindow extends Frame {
    ResultWindow(int total, float avg, String result) {
        setTitle("Student Result");
        setSize(250, 200);
        setLayout(new FlowLayout());

        add(new Label("Total Marks: " + total));
        add(new Label("Average: " + avg));
        add(new Label("Result: " + result));

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose(); // Close only this window
            }
        });
    }
}
