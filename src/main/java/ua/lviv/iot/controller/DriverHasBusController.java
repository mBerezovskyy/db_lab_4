package ua.lviv.iot.controller;

import ua.lviv.iot.dao.DriverHasBusDAO;
import ua.lviv.iot.model.DriverHasBus;

import java.sql.SQLException;
import java.util.List;

public class DriverHasBusController implements GeneralController<DriverHasBus> {

  DriverHasBusDAO dao = new DriverHasBusDAO();

  @Override
  public List<DriverHasBus> findAll() throws SQLException {
    return dao.findAll();
  }

  @Override
  public DriverHasBus findById(Integer id) throws SQLException {
    return dao.findById(id);
  }

  @Override
  public void create(DriverHasBus driverHasBus) throws SQLException {
    dao.create(driverHasBus);
  }

  @Override
  public void update(Integer id, DriverHasBus driverHasBus) throws SQLException {
    dao.update(id, driverHasBus);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    dao.delete(id);
  }
}
