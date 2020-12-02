package ua.lviv.iot.controller;

import ua.lviv.iot.dao.ManufacturerDAO;
import ua.lviv.iot.model.Manufacturer;

import java.sql.SQLException;
import java.util.List;

public class ManufacturerController implements GeneralController<Manufacturer> {

  ManufacturerDAO manufacturerDAO = new ManufacturerDAO();

  @Override
  public List<Manufacturer> findAll() throws SQLException {
    return manufacturerDAO.findAll();
  }

  @Override
  public Manufacturer findById(Integer id) throws SQLException {
    return manufacturerDAO.findById(id);
  }

  @Override
  public void create(Manufacturer manufacturer) throws SQLException {
    manufacturerDAO.create(manufacturer);
  }

  @Override
  public void update(Integer id, Manufacturer manufacturer) throws SQLException {
    manufacturerDAO.update(id, manufacturer);
  }

  @Override
  public void delete(Integer id) throws SQLException {
    manufacturerDAO.delete(id);
  }
}
