package ua.lviv.iot.dao;


import ua.lviv.iot.model.Manufacturer;
import ua.lviv.iot.connection.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ManufacturerDAO implements GeneralDAO<Manufacturer> {

  private static final String SELECT_ALL = "SELECT * FROM fixbus_db.manufacturer";
  private static final String SELECT_ONE = "SELECT * FROM fixbus_db.manufacturer WHERE id=?";
  private static final String CREATE = "INSERT fixbus_db.manufacturer(name, phone_number, office_adress) " +
      "VALUES (?,?,?)";
  private static final String UPDATE = "UPDATE fixbus_db.manufacturer"
      + " SET name=?, phone_number=?, office_adress=? WHERE id=?";
  private static final String DELETE = "DELETE FROM fixbus_db.manufacturer WHERE id=?";


  @Override
  public List<Manufacturer> findAll() throws SQLException {
    List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
      System.out.println(ps);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        Manufacturer manufacturer = new Manufacturer(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("phone_number"),
            resultSet.getString("office_adress"));
        manufacturers.add(manufacturer);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return manufacturers;
  }

  @Override
  public Manufacturer findById(Integer id) throws SQLException {
    Manufacturer manufacturer = null;
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        manufacturer = new Manufacturer(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("phone_number"),
            resultSet.getString("office_adress"));
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return manufacturer;
  }


  @Override
  public void create(Manufacturer newManufacturer) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
      ps.setString(2, newManufacturer.getPhoneNumber());
      ps.setString(3, String.valueOf(newManufacturer.getOfficeAdress()));
      ps.setString(1, newManufacturer.getName());
      ps.executeUpdate();
      System.out.println(ps);

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }


  @Override
  public void update(Integer id, Manufacturer updatedManufacturer) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
      ps.setString(2, updatedManufacturer.getPhoneNumber());
      ps.setString(3, updatedManufacturer.getOfficeAdress());
      ps.setString(1, updatedManufacturer.getName());
      ps.setInt(4, id);
      ps.executeUpdate();
      System.out.println(ps);

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void delete(Integer id) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(DELETE)) {
      ps.setInt(1, id);
      System.out.println(ps);
      ps.executeUpdate();

    } catch (Exception exception) {
      exception.printStackTrace();
    }

  }
}