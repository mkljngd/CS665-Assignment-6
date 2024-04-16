/**
 * Name: Mukul Jangid 
 * Course: CS-665 Software Designs & Patterns 
 * Date: 04/12/2024 
 * File Name: Driver.java 
 * Description: The Driver class represents a participant in the delivery system, acting
 * as an observer that reacts to changes in the delivery request status. Drivers can receive
 * notifications about new delivery requests if they are available.
 */

package edu.bu.met.cs665;

import java.util.logging.Logger;

public class Driver implements Observer {
  private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());
  private String driverId;
  private String name;
  private boolean isAvailable;

  /**
   * Constructs a new Driver with the specified ID and name. The driver is available by default.
   *
   * @param driverId The unique identifier for the driver.
   * @param name The name of the driver.
   */
  public Driver(String driverId, String name) {
    this.driverId = driverId;
    this.name = name;
    this.isAvailable = true; // Assuming driver is available by default
  }

  /**
   * Notifies the driver about a new delivery request if they are available.
   *
   * @param request The delivery request to be notified about.
   */
  @Override
  public void update(DeliveryRequest request) {
    if (this.isAvailable) {
      LOGGER.info("Driver " + name + " notified about delivery request: " + request.getOrderId());
    } else {
      LOGGER.warning("Attempted to notify unavailable driver: " + name);
    }
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
    LOGGER.info("Driver " + name + " availability set to " + isAvailable);
  }
}
