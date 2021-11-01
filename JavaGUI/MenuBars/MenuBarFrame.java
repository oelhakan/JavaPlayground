package Playground.MenuBars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBarFrame extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;
    JMenuItem saveItem;
    JMenuItem loadItem;
    JMenuItem exitItem;

    ImageIcon loadIcon;
    ImageIcon saveIcon;
    ImageIcon exitIcon;

    MenuBarFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        loadIcon = new ImageIcon("file.png");
        saveIcon = new ImageIcon("save.png");
        exitIcon = new ImageIcon("exit.png");

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        saveItem = new JMenuItem("Save");
        loadItem = new JMenuItem("Load");
        exitItem = new JMenuItem("Exit");

        saveItem.setIcon(saveIcon);
        loadItem.setIcon(loadIcon);
        exitItem.setIcon(exitIcon);

        saveItem.addActionListener(this);
        loadItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.setMnemonic(KeyEvent.VK_F);    //ALT/OPTION + F FOR FILE
        editMenu.setMnemonic(KeyEvent.VK_E);    //ALT/OPTION + E FOR EDIT
        helpMenu.setMnemonic(KeyEvent.VK_H);    //ALT/OPTION + H FOR HELP

        saveItem.setMnemonic(KeyEvent.VK_S);    //S FOR SAVE
        loadItem.setMnemonic(KeyEvent.VK_L);    //L FOR LOAD
        exitItem.setMnemonic(KeyEvent.VK_E);    //E FOR EXIT

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(saveItem)) {
            System.out.println("You Saved A File");
        }
        if (e.getSource().equals(loadItem)) {
            System.out.println("You Loaded A File");
        }
        if (e.getSource().equals(exitItem)) {
            System.exit(0);
        }
    }
}
