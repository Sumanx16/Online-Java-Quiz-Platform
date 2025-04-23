
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {

    JLabel title, l, greetingLabel;
    JRadioButton jb[] = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    OnlineTest(String s) {
        super(s);

        // Set Nimbus Look and Feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Look and Feel not set.");
        }

        // Greeting and Title
        greetingLabel = new JLabel("👋 Welcome to the Online Java Quiz!", JLabel.CENTER);
        greetingLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        greetingLabel.setForeground(new Color(0, 153, 76));
        add(greetingLabel);

        title = new JLabel("Test Your Java Knowledge", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(new Color(0, 102, 204));
        add(title);

        l = new JLabel();
        l.setFont(new Font("Verdana", Font.PLAIN, 18));
        add(l);

        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            jb[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(jb[i]);
            bg.add(jb[i]);
        }

        b1 = new JButton("Next");
        b1.setBackground(new Color(0, 153, 76));
        b1.setForeground(Color.WHITE);
        b2 = new JButton("Bookmark");
        b2.setBackground(new Color(255, 153, 0));
        b2.setForeground(Color.BLACK);

        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);

        set();
        setLayout(null);

        // Adjusted Bounds for bigger UI
        greetingLabel.setBounds(250, 10, 400, 30);
        title.setBounds(250, 50, 400, 35);
        l.setBounds(80, 100, 700, 25);
        jb[0].setBounds(100, 140, 700, 30);
        jb[1].setBounds(100, 180, 700, 30);
        jb[2].setBounds(100, 220, 700, 30);
        jb[3].setBounds(100, 260, 700, 30);
        b1.setBounds(250, 340, 140, 45);
        b2.setBounds(440, 340, 160, 45);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 550); // Increased window size
        setLocationRelativeTo(null); // Center screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check()) {
                count++;
            }
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }

        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(700, 100 + 30 * x, 120, 30);
            bk.setFont(new Font("Arial", Font.PLAIN, 12));
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9) {
                b2.setText("Result");
            }
            setVisible(false);
            setVisible(true);
        }

        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check()) {
                    count++;
                }
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check()) {
                count++;
            }

            int total = 10;
            int percentage = (count * 100) / total;

            JOptionPane.showMessageDialog(this,
                    "✅ Quiz Completed!\n"
                    + "✔ Correct Answers: " + count + "/" + total + "\n"
                    + "📊 Score: " + percentage + "%\n\n"
                    + "🎉 Thank you for taking the quiz!");

            System.exit(0);
        }
    }

    void set() {
        jb[4].setSelected(true);
        switch (current) {
            case 0 -> {
                l.setText("Q1: Which one among these is not a datatype?");
                jb[0].setText("int");
                jb[1].setText("Float");
                jb[2].setText("boolean");
                jb[3].setText("char");
            }
            case 1 -> {
                l.setText("Q2: Which class is available to all classes automatically?");
                jb[0].setText("Swing");
                jb[1].setText("Applet");
                jb[2].setText("Object");
                jb[3].setText("ActionEvent");
            }
            case 2 -> {
                l.setText("Q3: Which package is available without importing?");
                jb[0].setText("swing");
                jb[1].setText("applet");
                jb[2].setText("net");
                jb[3].setText("lang");
            }
            case 3 -> {
                l.setText("Q4: String class is defined in which package?");
                jb[0].setText("lang");
                jb[1].setText("Swing");
                jb[2].setText("Applet");
                jb[3].setText("awt");
            }
            case 4 -> {
                l.setText("Q5: Which institute is best for Java coaching?");
                jb[0].setText("Utek");
                jb[1].setText("Aptech");
                jb[2].setText("SSS IT");
                jb[3].setText("jtek");
            }
            case 5 -> {
                l.setText("Q6: Which one is not a keyword?");
                jb[0].setText("class");
                jb[1].setText("int");
                jb[2].setText("get");
                jb[3].setText("if");
            }
            case 6 -> {
                l.setText("Q7: Which is not a class?");
                jb[0].setText("Swing");
                jb[1].setText("Actionperformed");
                jb[2].setText("ActionEvent");
                jb[3].setText("Button");
            }
            case 7 -> {
                l.setText("Q8: Which is not a function of Object class?");
                jb[0].setText("toString");
                jb[1].setText("finalize");
                jb[2].setText("equals");
                jb[3].setText("getDocumentBase");
            }
            case 8 -> {
                l.setText("Q9: Which function is not present in Applet class?");
                jb[0].setText("init");
                jb[1].setText("main");
                jb[2].setText("start");
                jb[3].setText("destroy");
            }
            case 9 -> {
                l.setText("Q10: Which one is not a valid component?");
                jb[0].setText("JButton");
                jb[1].setText("JList");
                jb[2].setText("JButtonGroup");
                jb[3].setText("JTextArea");
            }
        }
    }

    boolean check() {
        return switch (current) {
            case 0 ->
                jb[1].isSelected();
            case 1 ->
                jb[2].isSelected();
            case 2 ->
                jb[3].isSelected();
            case 3 ->
                jb[0].isSelected();
            case 4 ->
                jb[2].isSelected();
            case 5 ->
                jb[2].isSelected();
            case 6 ->
                jb[1].isSelected();
            case 7 ->
                jb[3].isSelected();
            case 8 ->
                jb[1].isSelected();
            case 9 ->
                jb[2].isSelected();
            default ->
                false;
        };
    }

    public static void main(String[] args) {
        new OnlineTest("🧠 Java Quiz Portal");
    }
}
