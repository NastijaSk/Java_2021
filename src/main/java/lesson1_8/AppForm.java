package lesson1_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppForm extends JFrame {
    public int count = 0;

    public AppForm() {
        setTitle("Счетчик");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 200);

        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));

        JButton minus10Button = new JButton("-10");
        add(minus10Button);
        JButton minusButton = new JButton("-");
        add(minusButton);

        JLabel label = new JLabel(Integer.toString(count), JLabel.CENTER);
        label.setPreferredSize(new Dimension(250, 100));
        add(label);
        JButton plusButton = new JButton("+");
        add(plusButton);
        JButton plus10Button = new JButton("+10");
        add(plus10Button);


        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count--;
                label.setText(String.valueOf(count));
                if (CheckCount() == false) {

                    label.setText("Предел");
                }
            }

        });
        minus10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count = count - 10;
                label.setText(String.valueOf(count));
                if (CheckCount() == false) {

                    label.setText("Предел");
                    ;
                }

            }
        });
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count++;
                label.setText(String.valueOf(count));
                if (CheckCount() == false) {

                    label.setText("Предел");
                    ;
                }

            }
        });
        plus10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                count = count + 10;
                label.setText(String.valueOf(count));
                if (CheckCount() == false) {

                    label.setText("Предел");
                    ;
                }

            }
        });

        setVisible(true);
    }

    public boolean CheckCount() {
        if (Math.abs(this.count) <= 50) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new AppForm();
    }
}

