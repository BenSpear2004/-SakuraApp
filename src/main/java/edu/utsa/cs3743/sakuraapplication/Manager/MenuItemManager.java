package edu.utsa.cs3743.sakuraapplication.Manager;

import edu.utsa.cs3743.sakuraapplication.Model.MenuItem;
import edu.utsa.cs3743.sakuraapplication.Manager.DataBaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemManager {


    public static List<MenuItem> getAllMenuItems() {
        List<MenuItem> list = new ArrayList<>();

        String sql = "SELECT menu_item_id, item_name, calories, price FROM Menu_items";

        try (PreparedStatement stmt = DataBaseManager.getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new MenuItem(
                        rs.getInt("menu_item_id"),
                        rs.getString("item_name"),
                        rs.getString("calories"),
                        rs.getDouble("price")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

