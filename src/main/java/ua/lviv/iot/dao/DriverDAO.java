package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Driver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO implements GeneralDAO<Driver> {

  private static final String SELECT_ALL = "SELECT * FROM fixbus_db.driver";
  private static final String SELECT_ONE = "SELECT * FROM fixbus_db.driver WHERE id=?";
  private static final String CREATE = "INSERT fixbus_db.driver (name, surname) VALUES (?,?)";
  private static final String UPDATE = "UPDATE fixbus_db.driver SET name=?, surname=? WHERE id=?";
  private static final String DELETE = "DELETE FROM fixbus_db.driver WHERE id=?";

  @Override
  public List<Driver> findAll() throws SQLException {
    List<Driver> drivers = new ArrayList<Driver>();
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
      System.out.println(ps);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        Driver driver = new Driver(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("surname"));
        drivers.add(driver);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return drivers;
  }

  @Override
  public Driver findById(Integer id) throws SQLException {
    Driver driver = null;
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        driver = new Driver(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("surname"));
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return driver;
  }

  @Override
  public void create(Driver driver) throws SQLException {

    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
      ps.setString(1, driver.getName());
      ps.setString(2, driver.getSurname());
      ps.executeUpdate();
      System.out.println(ps);

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public void update(Integer id, Driver newDriver) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
      ps.setInt(3, id);
      ps.setString(1, newDriver.getName());
      ps.setString(2, newDriver.getSurname());

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
