package ua.lviv.iot.controller;

import ua.lviv.iot.dao.DriverHasRouteDAO;
import ua.lviv.iot.model.DriverHasRoute;

import java.sql.SQLException;
import java.util.List;

public class DriverHasRouteController implements GeneralController<DriverHasRoute> {

  DriverHasRouteDAO dao = new DriverHasRouteDAO();

  @Override
  public List<DriverHasRoute> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public DriverHasRoute findById(Integer id) throws SQLException {
    return dao.findById(id);
  }

  @Override
  public void create(DriverHasRoute driverHasRoute) throws SQLException {
    dao.create(driverHasRoute);
  }

  @Override
  public void update(Integer id, DriverHasRoute driverHasRoute) throws SQLException {
    dao.update(id, driverHasRoute);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);
  }
}
