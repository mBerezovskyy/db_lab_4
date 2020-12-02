package ua.lviv.iot.dao;

import ua.lviv.iot.connection.DbConnector;
import ua.lviv.iot.model.Stop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StopDAO implements GeneralDAO<Stop> {

  private static final String SELECT_ALL = "SELECT * FROM fixbus_db.stop";
  private static final String SELECT_ONE = "SELECT * FROM fixbus_db.stop WHERE id=?";
  private static final String CREATE = "INSERT fixbus_db.stop (district, street_name, street_number) VALUES (?,?, ?)";
  private static final String UPDATE = "UPDATE fixbus_db.stop SET district=?, street_name=?, street_number=? WHERE id=?";
  private static final String DELETE = "DELETE FROM fixbus_db.stop WHERE id=?";

  @Override
  public List<Stop> findAll() throws SQLException {
    List<Stop> profiles = new ArrayList<Stop>();
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ALL)) {
      System.out.println(ps);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        Stop stop = new Stop(
            resultSet.getInt("id"),
            resultSet.getString("district"),
            resultSet.getString("street_name"),
            resultSet.getString("street_number"));
        profiles.add(stop);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return profiles;
  }

  @Override
  public Stop findById(Integer id) throws SQLException {
    Stop stop = null;
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(SELECT_ONE)) {
      ps.setInt(1, id);
      ResultSet resultSet = ps.executeQuery();
      while (resultSet.next()) {
        stop = new Stop(
            resultSet.getInt("id"),
            resultSet.getString("district"),
            resultSet.getString("street_name"),
            resultSet.getString("street_number"));
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return stop;
  }

  @Override
  public void create(Stop profile) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(CREATE)) {
      ps.setString(1, profile.getDistrict());
      ps.setString(2, profile.getStreetName());
      ps.setString(3, profile.getStreetNumber());
      ps.executeUpdate();
      System.out.println(ps);

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }


  @Override
  public void update(Integer id, Stop profile) throws SQLException {
    try (PreparedStatement ps = DbConnector.getConnection().prepareStatement(UPDATE)) {
      ps.setInt(4, id);
      ps.setString(1, profile.getDistrict());
      ps.setString(2, profile.getStreetName());
      ps.setString(3, profile.getStreetNumber());

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
