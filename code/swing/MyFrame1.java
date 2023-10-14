package org.example.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

public class MyFrame1 extends JFrame {
    private JPanel panel1;
    private JTable table1;
    private JTextField TFName;
    private JTextField TFEmail;
    private JTextField TFMobile;
    private JTextField TFRefresh;
    private JTextField TFId;

    private JComboBox<String> comboBox1;
    private JTextArea TA1;

    private JCheckBox hindiCheckBox;
    private JCheckBox teluguCheckBox;
    private JCheckBox englishCheckBox;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;

    private JButton insertButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton refreshFormButton;
    private JButton refreshButton;
    private JLabel imageLabel;
    private JButton chooseImageButton;

    public static DefaultTableModel model;
    public static TableRowSorter<DefaultTableModel> sorter;
    public static ArrayList<String> componentList = new ArrayList<>();

    public JTable getTable1() {
        return table1;
    }

    public JTextField getTFName() {
        return TFName;
    }

    public JTextField getTFEmail() {
        return TFEmail;
    }

    public JTextField getTFMobile() {
        return TFMobile;
    }

    public JTextField getTFRefresh() {
        return TFRefresh;
    }

    public JTextField getTFId() {
        return TFId;
    }

    public JComboBox<String> getComboBox1() {
        return comboBox1;
    }

    public JTextArea getTA1() {
        return TA1;
    }

    public JCheckBox getHindiCheckBox() {
        return hindiCheckBox;
    }

    public JCheckBox getTeluguCheckBox() {
        return teluguCheckBox;
    }

    public JCheckBox getEnglishCheckBox() {
        return englishCheckBox;
    }

    public JRadioButton getMaleRadioButton() {
        return maleRadioButton;
    }

    public JRadioButton getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public JButton getInsertButton() {
        return insertButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getRefreshFormButton() {
        return refreshFormButton;
    }

    public JButton getRefreshButton() {
        return refreshButton;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public JButton getChooseImageButton() {
        return chooseImageButton;
    }

    public MyFrame1() throws Exception {
        super("CRUD");

        Util.setUpTable(this);
        Util.setUpListener(this);
        Util.setUpComboBox(this);

        setContentPane(panel1);
        setMinimumSize(new Dimension(1000, 650));
        setLocationRelativeTo(null);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
