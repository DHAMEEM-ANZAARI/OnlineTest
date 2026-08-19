import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {

    JLabel l;
    JRadioButton jb[] = new JRadioButton[4];                                                                                               
    JButton b1, b2;
    ButtonGroup bg;

    int count = 0, current = 0, x = 1;
    int m[] = new int[10];                     
    boolean reviewMode = false;
    int returnIndex = -1;

    OnlineTest(String s) {
        super(s);
        l = new JLabel();
        add(l);

        bg = new ButtonGroup();
        for (int i = 0; i < jb.length; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }

        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);

        set();

        l.setBounds(30, 40, 450, 20);
        for (int i = 0; i < jb.length; i++) {
            jb[i].setBounds(50, 80 + 30 * i, 200, 20);
        }
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    public void actionPerformed(ActionEvent e) {

        // ---- Next button ----
        if (e.getSource() == b1) {
            if (reviewMode) {
                if (check()) count++;
                reviewMode = false;
                current = returnIndex;
                set();
            } else {
                if (check()) count++;
                current++;
                set();
            }

            if (current == 9 && !reviewMode) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
            return;
        }

        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;

            if (check()) count++;     
            current++;
            set();

            if (current == 9) {
                b2.setText("Result");
            }
            setVisible(false);
            setVisible(true);
            return;
        }

        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (!reviewMode) {
                    returnIndex = current;   
                }
                reviewMode = true;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                return;
            }
        }

      
        if (e.getActionCommand().equals("Result")) {
            if (check()) count++;
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            System.exit(0);
        }
    }

    void set() {
        bg.clearSelection();  

        if (current == 0) {
            l.setText("Que1: Which one among these is not a primitive datatype");
            jb[0].setText("int"); jb[1].setText("Float"); jb[2].setText("boolean"); jb[3].setText("char");
        }
        if (current == 1) {
            l.setText("Que2: Which class is available to all classes automatically");
            jb[0].setText("Swing"); jb[1].setText("Applet"); jb[2].setText("Object"); jb[3].setText("ActionEvent");
        }
        if (current == 2) {
            l.setText("Que3: Which package is directly available to our class without importing it");
            jb[0].setText("swing"); jb[1].setText("applet"); jb[2].setText("net"); jb[3].setText("lang");
        }
        if (current == 3) {
            l.setText("Que4: String class is defined in which package");
            jb[0].setText("lang"); jb[1].setText("Swing"); jb[2].setText("Applet"); jb[3].setText("awt");
        }
        if (current == 4) {
            l.setText("Que5: Which institute is best for java coaching");
            jb[0].setText("Utek"); jb[1].setText("Aptech"); jb[2].setText("SSS IT"); jb[3].setText("jtek");
        }
        if (current == 5) {
            l.setText("Que6: Which one among these is not a keyword");
            jb[0].setText("class"); jb[1].setText("int"); jb[2].setText("get"); jb[3].setText("if");
        }
        if (current == 6) {
            l.setText("Que7: Which one among these is not a class");
            jb[0].setText("Swing"); jb[1].setText("ActionPerformed"); jb[2].setText("ActionEvent"); jb[3].setText("Button");
        }
        if (current == 7) {
            l.setText("Que8: Which one among these is not a function of Object class");
            jb[0].setText("toString"); jb[1].setText("finalize"); jb[2].setText("equals"); jb[3].setText("getDocumentBase");
        }
        if (current == 8) {
            l.setText("Que9: Which function is not present in Applet class");
            jb[0].setText("init"); jb[1].setText("main"); jb[2].setText("start"); jb[3].setText("destroy");
        }
        if (current == 9) {
            l.setText("Que10: Which one among these is not a valid component");
            jb[0].setText("JButton"); jb[1].setText("JList"); jb[2].setText("JButtonGroup"); jb[3].setText("JTextArea");
        }

        l.setBounds(30, 40, 450, 20);
        for (int i = 0; i < jb.length; i++) {
            jb[i].setBounds(50, 80 + 30 * i, 200, 20);
        }
    }

    boolean check() {
        switch (current) {
            case 0: return jb[1].isSelected();
            case 1: return jb[2].isSelected();
            case 2: return jb[3].isSelected();
            case 3: return jb[0].isSelected();
            case 4: return jb[2].isSelected();
            case 5: return jb[2].isSelected();
            case 6: return jb[1].isSelected();
            case 7: return jb[3].isSelected();
            case 8: return jb[1].isSelected();
            case 9: return jb[2].isSelected();
            default: return false;
        }
    }

    public static void main(String s[]) {
        new OnlineTest("Online Test Of Java");
    }
}
