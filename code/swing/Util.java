package org.example.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Util {
    static ButtonGroup buttonGroup;
    public static File f = new File("C:/Users/DELL/Documents/noPic.png");

    public static void alert(String msg, String title) {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void alert(String msg) {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), msg);
    }

    public static int getDeleteConfirmation() {
        return JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(), "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
    }

    public static void refresh(MyFrame1 myFrame1) {
        myFrame1.getTFRefresh().setText("");
    }

    public static void clear(MyFrame1 myFrame1) {
        f = new File("C:/Users/DELL/Documents/noPic.png");
        myFrame1.getImageLabel().setIcon(null);
        myFrame1.getTFId().setText("");
        myFrame1.getTFName().setText("");
        myFrame1.getTFEmail().setText("");
        myFrame1.getTFMobile().setText("");
        myFrame1.getComboBox1().setSelectedIndex(0);
        myFrame1.getTA1().setText("");
        myFrame1.getHindiCheckBox().setSelected(false);
        myFrame1.getEnglishCheckBox().setSelected(false);
        myFrame1.getTeluguCheckBox().setSelected(false);
        buttonGroup.clearSelection();
    }

    public static boolean checkForEmptyField(MyFrame1 myFrame1) {

        MyFrame1.componentList.clear();

        if (myFrame1.getTFId().getText().equals("")) {
            alert("fill id");
            return false;
        } else {
            MyFrame1.componentList.add(myFrame1.getTFId().getText());
        }

        if (myFrame1.getTFName().getText().equals("")) {
            alert("fill name");
            return false;
        } else {
            MyFrame1.componentList.add(myFrame1.getTFName().getText());
        }

        if (myFrame1.getTFEmail().getText().equals("")) {
            alert("fill email");
            return false;
        } else {
            MyFrame1.componentList.add(myFrame1.getTFEmail().getText());
        }

        if (myFrame1.getTFMobile().getText().equals("")) {
            alert("fill MOBILE");
            return false;
        } else {
            MyFrame1.componentList.add(myFrame1.getTFMobile().getText());
        }

        if (Objects.equals(myFrame1.getComboBox1().getSelectedItem(), "Select a city")) {
            alert("fill city");
            return false;
        } else {
            MyFrame1.componentList.add(myFrame1.getComboBox1().getSelectedItem().toString());
        }

        if (myFrame1.getTA1().getText().equals("")) {
            alert("fill address");
            return false;
        } else {
            MyFrame1.componentList.add(myFrame1.getTA1().getText());
        }

        if (myFrame1.getHindiCheckBox().isSelected()) {
            MyFrame1.componentList.add("1");
        } else {
            MyFrame1.componentList.add("0");
        }

        if (myFrame1.getEnglishCheckBox().isSelected()) {
            MyFrame1.componentList.add("1");
        } else {
            MyFrame1.componentList.add("0");
        }

        if (myFrame1.getTeluguCheckBox().isSelected()) {
            MyFrame1.componentList.add("1");
        } else {
            MyFrame1.componentList.add("0");

        }

        if (!myFrame1.getMaleRadioButton().isSelected() && !myFrame1.getFemaleRadioButton().isSelected()) {
            alert("fill gender");
            return false;
        } else {
            if (myFrame1.getMaleRadioButton().isSelected()) {
                MyFrame1.componentList.add("male");
            } else {
                MyFrame1.componentList.add("female");
            }
        }
        if (f.getAbsolutePath().equals("C:/Users/DELL/Documents/noPic.png")) {
            MyFrame1.componentList.add("C:/Users/DELL/Documents/noPic.png");
        } else {
            String[] arr = Util.f.getAbsolutePath().split("\\\\");
            String join = String.join("/", arr);
            MyFrame1.componentList.add(join);
        }

        // MyFrame1.componentList.add(UserCrud.image_path);
        return true;
    }

    public static void whenRowIsSelected(MyFrame1 myFrame1) throws IOException {
        int i = myFrame1.getTable1().getSelectedRow();


        myFrame1.getTFId().setText(myFrame1.getTable1().getValueAt(i, 0).toString());
        myFrame1.getTFName().setText(myFrame1.getTable1().getValueAt(i, 1).toString());
        myFrame1.getTFEmail().setText(myFrame1.getTable1().getValueAt(i, 2).toString());
        myFrame1.getTFMobile().setText(myFrame1.getTable1().getValueAt(i, 3).toString());
        switch (myFrame1.getTable1().getValueAt(i, 4).toString()) {
            case "Mumbai":
                myFrame1.getComboBox1().setSelectedIndex(1);
                break;
            case "Pune":
                myFrame1.getComboBox1().setSelectedIndex(2);
                break;
            case "Chennai":
                myFrame1.getComboBox1().setSelectedIndex(3);
                break;
            case "Hyderabad":
                myFrame1.getComboBox1().setSelectedIndex(4);
                break;
        }
        myFrame1.getTA1().setText(myFrame1.getTable1().getValueAt(i, 5).toString());
        if (myFrame1.getTable1().getValueAt(i, 6).toString().equals("1")) myFrame1.getHindiCheckBox().setSelected(true);
        else myFrame1.getHindiCheckBox().setSelected(false);

        if (myFrame1.getTable1().getValueAt(i, 7).toString().equals("1"))
            myFrame1.getEnglishCheckBox().setSelected(true);
        else myFrame1.getEnglishCheckBox().setSelected(false);

        if (myFrame1.getTable1().getValueAt(i, 8).toString().equals("1"))
            myFrame1.getTeluguCheckBox().setSelected(true);
        else myFrame1.getTeluguCheckBox().setSelected(false);

        buttonGroup = new ButtonGroup();

        buttonGroup.add(myFrame1.getMaleRadioButton());
        buttonGroup.add(myFrame1.getFemaleRadioButton());

        if (myFrame1.getTable1().getValueAt(i, 9).toString().equals("male"))
            myFrame1.getMaleRadioButton().setSelected(true);
        else myFrame1.getFemaleRadioButton().setSelected(true);

        String path = myFrame1.getTable1().getValueAt(i, 10).toString();
        f = new File(path);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(ImageIO.read(f.getAbsoluteFile())).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        myFrame1.getImageLabel().setIcon(imageIcon);

    }

    public static void setUpTable(MyFrame1 myFrame1) throws Exception {
        JTable table1 = myFrame1.getTable1();
        String[] columnNames = {"Id", "Name", "Email", "Mobile number", "City", "Address", "Hindi", "English", "Telugu", "Gender" , "Image path"};
        Object[][] rowData = {};
        MyFrame1.model = new DefaultTableModel(rowData, columnNames);
        UserCrud.select(myFrame1);
        table1.setModel(MyFrame1.model);
        MyFrame1.sorter = new TableRowSorter<>(MyFrame1.model);
        table1.setRowSorter(MyFrame1.sorter);

        table1.getColumnModel().getColumn(1).setPreferredWidth(180);
        table1.getColumnModel().getColumn(3).setPreferredWidth(100);
        table1.getColumnModel().getColumn(2).setPreferredWidth(300);
        table1.getColumnModel().getColumn(5).setPreferredWidth(250);
    }

    public static void setUpListener(MyFrame1 myFrame1) {
        myFrame1.getInsertButton().addActionListener(e -> {
            try {
                if (checkForEmptyField(myFrame1)) {
                    UserCrud.insert();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        myFrame1.getUpdateButton().addActionListener(e -> {
            try {
                if (myFrame1.getTable1().getSelectedRows().length == 0) {
                    alert("Please select a row");
                } else if (checkForEmptyField(myFrame1)) {
                    UserCrud.update(myFrame1);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        myFrame1.getDeleteButton().addActionListener(e -> {
            try {
                UserCrud.delete(myFrame1);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        myFrame1.getTable1().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    whenRowIsSelected(myFrame1);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        myFrame1.getTFRefresh().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(myFrame1.getTFRefresh().getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(myFrame1.getTFRefresh().getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(myFrame1.getTFRefresh().getText());
            }

            public void search(String str) {
                if (str.length() == 0) {
                    MyFrame1.sorter.setRowFilter(null);
                } else {
                    MyFrame1.sorter.setRowFilter(RowFilter.regexFilter(str));
                }
            }
        });

        myFrame1.getTable1().setDefaultEditor(Object.class, null);
        myFrame1.getRefreshButton().addActionListener(e -> refresh(myFrame1));
        myFrame1.getRefreshFormButton().addActionListener(e -> clear(myFrame1));
        myFrame1.getChooseImageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showSaveDialog(null);
                f = chooser.getSelectedFile();
                ImageIcon imageIcon = null;
                try {
                    imageIcon = new ImageIcon(new ImageIcon(ImageIO.read(new File(f.getAbsolutePath()))).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                myFrame1.getImageLabel().setIcon(imageIcon);
            }
        });
    }

    public static void setUpComboBox(MyFrame1 myFrame1) {
        DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<>(new String[]{"Select a city", "Mumbai", "Pune", "Chennai", "Hyderabad"});
        myFrame1.getComboBox1().setModel(dcm);
    }

}
