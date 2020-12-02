package ua.lviv.iot.controller;

import ua.lviv.iot.dao.DriverDAO;
import ua.lviv.iot.model.Driver;

import java.sql.SQLException;
import java.util.List;

public class DriverController implements GeneralController<Driver> {

  DriverDAO driverDAO = new DriverDAO();

  @Override
  public List<Driver> findAll() throws SQLException {
    return driverDAO.findAll();
  }

  @Override
  public Driver findById(Integer id) throws SQLException {
    return driverDAO.findById(id);
  }

  @Override
  public void create(Driver driver) throws SQLException {
    driverDAO.create(driver);
  }

  @Override
  public void update(Integer id, Driver driver) throws SQLException {
    driverDAO.update(id, driver);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    driverDAO.delete(id);
  }
}
