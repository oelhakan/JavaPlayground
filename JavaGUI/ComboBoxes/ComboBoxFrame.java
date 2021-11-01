package Playground.ComboBoxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxFrame extends JFrame implements ActionListener {
    //JComboBox = A Component that combines a button or editable field and a drop-down list
    JComboBox comboBox;
    ComboBoxFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] animals = {"Bird","Dog","Cat"};    //use wrapper classes for primitive data types
        comboBox = new JComboBox(animals);
        comboBox.addActionListener(this);
//        comboBox.setEditable(true);
//        System.out.println(comboBox.getItemCount());
//        comboBox.addItem("Horse");
//        comboBox.insertItemAt("Pig",0);
//        comboBox.setSelectedIndex(0);
//        comboBox.removeItem("Cat");
//        comboBox.removeItemAt(0);
//        comboBox.removeAllItems();

        this.add(comboBox);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(comboBox)){
            System.out.println(comboBox.getSelectedItem());
            System.out.println(comboBox.getSelectedIndex());
        }
    }
}
