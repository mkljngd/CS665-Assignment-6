/**
 * Name: Mukul Jangid 
 * Course: CS-665 Software Designs & Patterns 
 * Date: 04/12/2024 
 * File Name: Main.java 
 * Description: The Main class serves as the entry point of the application, where the observer 
 * design pattern is demonstrated. It initializes the system, then subscribes drivers to the 
 * notification service, simulates the creation of a delivery request, and shows subscribed 
 * drivers are notified about the new delivery request.
 */

package edu.bu.met.cs665;

/**
 * Demonstrates the functionality of the delivery notification system. This class initializes the
 * system, creates several drivers, subscribes them to a notification service, and then notifies
 * them about a new delivery request.
 */
public class Main {
  /**
   * The entry point of the application.
   *
   * @param args The command-line arguments (not used).
   */
  public static void main(String[] args) {

    Shop shop = new Shop("Best Shop", "123 Main St");
    Driver[] drivers = new Driver[5];

    for (int i = 0; i < drivers.length; i++) {
      drivers[i] = new Driver("D" + (i + 1), "Driver" + (i + 1));
      shop.subscribe(drivers[i]);
    }

    drivers[1].setAvailable(false); // Set driver2 as unavailable
    drivers[2].setAvailable(false); // Set driver3 as unavailable

    DeliveryRequest request = shop.createDeliveryRequest("YOLO", "25 Chester St", "Ferrari");
  }
}
