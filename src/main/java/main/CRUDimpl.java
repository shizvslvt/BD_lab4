package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDimpl implements CRUD {
    @Override
    public void Create(Connection connection, Estate estate) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ro_estates (seller_id, title, cost, type, locality, city, area, bedrooms, floors, date_created, viewed, deal, archived) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, estate.getSellerId());
            preparedStatement.setString(2, estate.getTitle());
            preparedStatement.setInt(3, estate.getCost());
            preparedStatement.setInt(4, estate.getType());
            preparedStatement.setInt(5, estate.getLocality());
            preparedStatement.setInt(6, estate.getCity());
            preparedStatement.setInt(7, estate.getArea());
            preparedStatement.setInt(8, estate.getBedrooms());
            preparedStatement.setInt(9, estate.getFloors());
            preparedStatement.setDate(10, new java.sql.Date(estate.getDateCreated().getTime()));
            preparedStatement.setInt(11, estate.getViewed());
            preparedStatement.setInt(12, estate.getDeal());
            preparedStatement.setInt(13, estate.getArchived());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Estate> Read(Connection connection) {
        List<Estate> estate_list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM ro_estates";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Estate estate = new Estate();
                estate.setId(resultSet.getInt("id"));
                estate.setSellerId(resultSet.getInt("seller_id"));
                estate.setTitle(resultSet.getString("title"));
                estate.setCost(resultSet.getInt("cost"));
                estate.setType(resultSet.getInt("type"));
                estate.setLocality(resultSet.getInt("locality"));
                estate.setCity(resultSet.getInt("city"));
                estate.setArea(resultSet.getInt("area"));
                estate.setBedrooms(resultSet.getInt("bedrooms"));
                estate.setFloors(resultSet.getInt("floors"));
                estate.setDateCreated(resultSet.getDate("date_created"));
                estate.setViewed(resultSet.getInt("viewed"));
                estate.setDeal(resultSet.getInt("deal"));
                estate.setArchived(resultSet.getInt("archived"));
                estate_list.add(estate);
            }
        } catch (SQLException e) { throw new RuntimeException(e); }
        return estate_list;
    }
    @Override
    public void Update(Connection connection, Estate estate, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ro_estates SET seller_id=?, title=?, cost=?, type=?, locality=?, city=?, area=?, bedrooms=?, floors=?, date_created=?, viewed=?, deal=?, archived=? WHERE id=?");

            preparedStatement.setInt(1, estate.getSellerId());
            preparedStatement.setString(2, estate.getTitle());
            preparedStatement.setInt(3, estate.getCost());
            preparedStatement.setInt(4, estate.getType());
            preparedStatement.setInt(5, estate.getLocality());
            preparedStatement.setInt(6, estate.getCity());
            preparedStatement.setInt(7, estate.getArea());
            preparedStatement.setInt(8, estate.getBedrooms());
            preparedStatement.setInt(9, estate.getFloors());
            preparedStatement.setDate(10, new java.sql.Date(estate.getDateCreated().getTime()));
            preparedStatement.setInt(11, estate.getViewed());
            preparedStatement.setInt(12, estate.getDeal());
            preparedStatement.setInt(13, estate.getArchived());

            preparedStatement.setInt(14, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void Delete(Connection connection, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ro_estates WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
