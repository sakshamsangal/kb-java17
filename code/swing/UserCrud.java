package org.example.swing;


import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserCrud {
    // public static String image_path;

    private static Statement statement;

    static {
        try {
            statement = Database.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void select(MyFrame1 myFrame1) throws Exception {
        MyFrame1.model.setRowCount(0);
        String sql = "SELECT * FROM user";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Object[] row = new Object[11];
            row[0] = resultSet.getString(1);
            row[1] = resultSet.getString(2);
            row[2] = resultSet.getString(3);
            row[3] = resultSet.getString(4);
            row[4] = resultSet.getString(5);
            row[5] = resultSet.getString(6);
            row[6] = resultSet.getString(7);
            row[7] = resultSet.getString(8);
            row[8] = resultSet.getString(9);
            row[9] = resultSet.getString(10);
            row[10] = resultSet.getString(11);
            MyFrame1.model.addRow(row);
        }

    }

    public static void insert() throws SQLException {
        ArrayList<String> l = MyFrame1.componentList;
        String sql = "select 1 from user where id=" + l.get(0);
        ResultSet rs = statement.executeQuery(sql);
        if (rs.first()) {
            Util.alert("Please provide a different id number", "Similar id found");
        } else {



            sql = "INSERT INTO user VALUES (" + l.get(0) + ", '" + l.get(1) + "', '" + l.get(2) + "', '" + l.get(3) + "', '" + l.get(4) + "', '" + l.get(5) + "', " + l.get(6) + ", " + l.get(7) + ", " + l.get(8) + ", '"  + l.get(9) + "', '"+ l.get(10) + "')";

            statement.executeUpdate(sql);
            ArrayList<Object> row = new ArrayList<>(l);
            MyFrame1.model.addRow(row.toArray());
            // Dialog.clear(TF1, TF2, TF3);
        }
    }


    public static void update(MyFrame1 myFrame1) throws SQLException {
        ArrayList<String> l = MyFrame1.componentList;

        String sql = "UPDATE user SET name='" + l.get(1) + "',email='" + l.get(2) + "',mobile_number='" + l.get(3) + "',city='" + l.get(4) + "',address='" + l.get(5) + "',hindi=" + l.get(6) + ",english=" + l.get(7) + ",telugu=" + l.get(8) + ",gender='" + l.get(9) + "', image_path='" + l.get(10) + "' WHERE id=" + l.get(0);
        // System.out.println(sql);
        statement.execute(sql);

        int rowIndex = myFrame1.getTable1().getSelectedRow();

        DefaultTableModel tableModel = (DefaultTableModel) myFrame1.getTable1().getModel();
        ArrayList<Object> row = new ArrayList<>(l);

        int actualIndex = myFrame1.getTable1().convertRowIndexToModel(rowIndex);
        tableModel.removeRow(actualIndex);
        tableModel.insertRow(actualIndex, row.toArray());
        // Dialog.clear(TF1, TF2, TF3);
    }

    public static void delete(MyFrame1 myFrame1) throws Exception {
        int length = myFrame1.getTable1().getSelectedRows().length;
        if (length == 1) {
            if (Util.getDeleteConfirmation() == 0) {
                int i = myFrame1.getTable1().getSelectedRow();
                String s = myFrame1.getTable1().getValueAt(i, 0).toString();
                String sql = "DELETE FROM user WHERE id=" + s;
                statement.execute(sql);
                int actualIndex = myFrame1.getTable1().convertRowIndexToModel(i);
                MyFrame1.model.removeRow(actualIndex);
            }
        } else {
            Util.alert("Please select a single row to delete");
        }
    }


}
