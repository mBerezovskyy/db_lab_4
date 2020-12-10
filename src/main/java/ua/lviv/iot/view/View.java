package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.model.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

  private static final Scanner scanner = new Scanner(System.in);
  private final Map<String, Printable> menu = new LinkedHashMap<>();

  private final RouteController routeController = new RouteController();
  private final ManufacturerController manufacturerController = new ManufacturerController();
  private final BusController busController = new BusController();
  private final DriverController driverController = new DriverController();
  private final StopController stopController = new StopController();
  private final DriverHasBusController driverHasBusController = new DriverHasBusController();
  private final DriverHasRouteController driverHasRouteController = new DriverHasRouteController();

  public View() {

    menu.put("11", this::getAllRoutes);
    menu.put("12", this::getRouteById);
    menu.put("13", this::createRoute);
    menu.put("14", this::updateRoute);
    menu.put("15", this::deleteRoute);

    menu.put("21", this::getAllManufacturers);
    menu.put("22", this::getManufacturerById);
    menu.put("23", this::createManufacturer);
    menu.put("24", this::updateManufacturer);
    menu.put("25", this::deleteManufacturer);

    menu.put("31", this::getAllBusses);
    menu.put("32", this::getBusById);
    menu.put("33", this::createBus);
    menu.put("34", this::updateBus);
    menu.put("35", this::deleteBus);

    menu.put("41", this::getAllDrivers);
    menu.put("42", this::getDriverById);
    menu.put("43", this::createDriver);
    menu.put("44", this::updateDriver);
    menu.put("45", this::deleteDriver);

    menu.put("51", this::getAllStops);
    menu.put("52", this::getStopId);
    menu.put("53", this::createStop);
    menu.put("54", this::updateStop);
    menu.put("55", this::deleteStop);

    menu.put("61", this::getAllDriverHasBus);
    menu.put("62", this::getDriverHasBusById);
    menu.put("63", this::createDriverHasBus);
    menu.put("64", this::updateDriverHasBus);
    menu.put("65", this::deleteDriverHasBus);

    menu.put("71", this::getAllDriverHasRoute);
    menu.put("72", this::getDriverHasRouteById);
    menu.put("73", this::createDriverHasRoute);
    menu.put("74", this::updateDriverHasRoute);
    menu.put("75", this::deleteDriverHasRoute);

  }

  private void deleteDriverHasRoute() throws SQLException {
    System.out.println("\nEnter ID of driver to delete him and his route: ");
    int id = scanner.nextInt();

    driverHasRouteController.delete(id);
    System.out.println("Deleted \n");
  }

  private void updateDriverHasRoute() throws SQLException {
    System.out.println("\nEnter id of driver with route to update: ");
    Integer id = scanner.nextInt();
    DriverHasRoute driverHasRoute = getDriverHasRouteValues();
    driverHasRoute.setId(id);

    driverHasRouteController.update(driverHasRoute.getId(), driverHasRoute);
    System.out.println("Updated \n");
  }

  private void createDriverHasRoute() throws SQLException {
    System.out.println("\nAdd new route to a driver");
    DriverHasRoute driverHasRoute = getDriverHasRouteValues();
    driverHasRouteController.create(driverHasRoute);
    System.out.println("added driver with route\n");
  }

  private void getDriverHasRouteById() throws SQLException {
    System.out.println("\nEnter id to find driver and his route with this id: ");
    Integer id = scanner.nextInt();
    System.out.println(driverHasBusController.findById(id) + "\n");
  }

  private void getAllDriverHasRoute() throws SQLException {
    System.out.println("\nAll info about driver's routes: ");
    System.out.println(driverHasRouteController.findAll() + "\n");
  }

  private void getAllRoutes() throws SQLException {
    System.out.println("\nAll routes: ");
    System.out.println(routeController.findAll() + "\n");
  }

  private void getAllManufacturers() throws SQLException {
    System.out.println("\nAll manufacturers: ");
    System.out.println(manufacturerController.findAll() + "\n");
  }

  private void getAllBusses() throws SQLException {
    System.out.println("\nAll Busses: ");
    System.out.println(busController.findAll() + "\n");
  }

  private void getAllDrivers() throws SQLException {
    System.out.println("\nAll drivers: ");
    System.out.println(driverController.findAll() + "\n");
  }

  private void getAllStops() throws SQLException {
    System.out.println("\nAll stops: ");
    System.out.println(stopController.findAll() + "\n");
  }

  private void getAllDriverHasBus() throws SQLException {
    System.out.println("\nAll info about driver's busses: ");
    System.out.println(driverHasBusController.findAll() + "\n");
  }

  private void getRouteById() throws SQLException {
    System.out.println("\nEnter id to find route with this id: ");
    Integer id = scanner.nextInt();
    System.out.println(routeController.findById(id) + "\n");
  }

  private void getManufacturerById() throws SQLException {
    System.out.println("\nEnter id to find manufacturer with this id: ");
    Integer id = scanner.nextInt();
    System.out.println(manufacturerController.findById(id) + "\n");
  }

  private void getBusById() throws SQLException {
    System.out.println("\nEnter id to find bus with this id:  ");
    Integer id = scanner.nextInt();
    System.out.println(busController.findById(id) + "\n");
  }

  private void getDriverById() throws SQLException {
    System.out.println("\nEnter id to find driver with this id: ");
    Integer id = scanner.nextInt();
    System.out.println(driverController.findById(id) + "\n");
  }

  private void getStopId() throws SQLException {
    System.out.println("\nEnter id to find stop with this id: ");
    Integer id = scanner.nextInt();
    System.out.println(stopController.findById(id) + "\n");
  }

  private void getDriverHasBusById() throws SQLException {
    System.out.println("\nEnter id to find driver and his bus with this id: ");
    Integer id = scanner.nextInt();
    System.out.println(driverHasBusController.findById(id) + "\n");
  }

  private DriverHasRoute getDriverHasRouteValues() {
    System.out.println("Input driver's id: ");
    Integer driverId = scanner.nextInt();
    System.out.println("Input route's id: ");
    Integer routeId = scanner.nextInt();
    return new DriverHasRoute(driverId, routeId);
  }

  private Route getRouteValues() throws SQLException {
    System.out.println("Input route's total fare: ");
    Integer totalFare = scanner.nextInt();
    System.out.println("Input route's starting stop id: ");
    Integer startingStopId = scanner.nextInt();
    System.out.println("Input route's end stop id: ");
    Integer endStopId = scanner.nextInt();
    return new Route(totalFare, startingStopId, endStopId);
  }

  private Manufacturer getManufacturerValues() throws SQLException {
    System.out.println("Input name: ");
    String name = scanner.next();
    System.out.println("Input phone number: ");
    String phoneNumber = scanner.next();
    System.out.println("Input office adress: ");
    String officeAdress = scanner.next();
    return new Manufacturer(name, phoneNumber, officeAdress);
  }

  private Bus getBusValues() throws SQLException {
    System.out.println("Input number sign: ");
    String numberSign = scanner.next();
    System.out.println("Input age: ");
    Integer age = scanner.nextInt();
    System.out.println("Input capacity: ");
    Integer capacity = scanner.nextInt();
    System.out.println("Input mileage: ");
    Integer mileage = scanner.nextInt();
    System.out.println("Input manufacturer Id: ");
    Integer manufacturerId = scanner.nextInt();
    return new Bus(numberSign, age, capacity, mileage, manufacturerId);
  }

  private Driver getDriverValues() throws SQLException {
    System.out.println("Input driver's name: ");
    String name = scanner.next();
    System.out.println("Input driver's surname: ");
    String surname = scanner.next();
    return new Driver(name, surname);
  }

  private Stop getStopValues() throws SQLException {
    System.out.println("Input district: ");
    String district = scanner.next();
    System.out.println("Input street name: ");
    String streetName = scanner.next();
    System.out.println("Input street number: ");
    String streetNumber = scanner.next();
    return new Stop(district, streetName, streetNumber);
  }

  private DriverHasBus getDriverHasBusValues() throws SQLException {
    System.out.println("Input driver id: ");
    Integer driverId = scanner.nextInt();
    System.out.println("Input bus id: ");
    Integer busId = scanner.nextInt();
    return new DriverHasBus(driverId, busId);
  }

  private void createRoute() throws SQLException {
    System.out.println("\nAdd new route");
    Route route = getRouteValues();
    routeController.create(route);
    System.out.println("added a route\n");
  }

  private void createManufacturer() throws SQLException {
    System.out.println("\nAdd new manufacturer ");
    Manufacturer manufacturer = getManufacturerValues();
    manufacturerController.create(manufacturer);
    System.out.println("added a manufacturer\n");
  }

  private void createBus() throws SQLException {
    System.out.println("\nAdd new bus ");
    Bus bus = getBusValues();
    busController.create(bus);
    System.out.println("added new bus\n");
  }

  private void createDriver() throws SQLException {
    System.out.println("\nAdd new driver ");
    Driver driver = getDriverValues();
    driverController.create(driver);
    System.out.println("added new driver\n");
  }

  private void createStop() throws SQLException {
    System.out.println("\nAdd new stop");
    Stop stop = getStopValues();
    stopController.create(stop);
    System.out.println("added a stop\n");
  }

  private void createDriverHasBus() throws SQLException {
    System.out.println("\nAdd new bus to a driver");
    DriverHasBus driverHasBus = getDriverHasBusValues();
    driverHasBusController.create(driverHasBus);
    System.out.println("added driver with bus\n");
  }

  private void updateManufacturer() throws SQLException {
    System.out.println("\nEnter id of manufacturer to update: ");
    Integer id = scanner.nextInt();
    Manufacturer manufacturer = getManufacturerValues();

    manufacturerController.update(id, manufacturer);
    System.out.println("Updated \n");
  }

  private void updateBus() throws SQLException {
    System.out.println("\nEnter id of bus to update it: ");
    Integer id = scanner.nextInt();
    Bus bus = getBusValues();

    busController.update(id, bus);
    System.out.println("Updated \n");
  }

  private void updateDriver() throws SQLException {
    System.out.println("\nEnter id of driver to update it: ");
    Integer id = scanner.nextInt();
    Driver driver = getDriverValues();

    driverController.update(id, driver);
    System.out.println("Updated \n");
  }

  private void updateStop() throws SQLException {
    System.out.println("\nEnter id of stop to update: ");
    Integer id = scanner.nextInt();
    Stop stop = getStopValues();

    stopController.update(id, stop);
    System.out.println("Updated \n");
  }

  private void updateDriverHasBus() throws SQLException {
    System.out.println("\nEnter id of driver with bus to update: ");
    Integer id = scanner.nextInt();
    DriverHasBus driverHasBus = getDriverHasBusValues();
    driverHasBus.setId(id);

    driverHasBusController.update(driverHasBus.getId(), driverHasBus);
    System.out.println("Updated \n");
  }

  private void updateRoute() throws SQLException {
    System.out.println("\nEnter id of route to update it: ");
    Integer id = scanner.nextInt();
    Route route = getRouteValues();

    routeController.update(id, route);
    System.out.println("Updated \n");
  }

  private void deleteRoute() throws SQLException {
    System.out.println("\nEnter ID of route to delete it: ");
    int id = scanner.nextInt();

    routeController.delete(id);
    System.out.println("Deleted \n");
  }

  private void deleteManufacturer() throws SQLException {
    System.out.println("\nEnter ID of manufacturer to delete it: ");
    int id = scanner.nextInt();

    manufacturerController.delete(id);
    System.out.println("Deleted \n");
  }

  private void deleteBus() throws SQLException {
    System.out.println("\nEnter ID of bus to delete it: ");
    int id = scanner.nextInt();

    busController.delete(id);
    System.out.println("Deleted \n");
  }

  private void deleteDriver() throws SQLException {
    System.out.println("\nEnter ID of driver to delete it: ");
    int id = scanner.nextInt();

    driverController.delete(id);
    System.out.println("Deleted \n");
  }

  private void deleteStop() throws SQLException {
    System.out.println("\nEnter ID of stop to delete it: ");
    int id = scanner.nextInt();

    stopController.delete(id);
    System.out.println("Deleted \n");
  }

  private void deleteDriverHasBus() throws SQLException {
    System.out.println("\nEnter ID of driver to delete his bus: ");
    int id = scanner.nextInt();

    driverHasBusController.delete(id);
    System.out.println("Deleted \n");
  }

  public final void view() {
    System.out.println("\nInput method number to deal with db:");
    String input;
    do {
      try {
        input = scanner.next();
        menu.get(input).print();
        System.out.println("\nInput number from menu:");
      } catch (Exception e) {
        System.out.println("No such option");
        System.out.println("\nInput number from menu:");
      }
    } while (scanner.hasNext());
  }

}

