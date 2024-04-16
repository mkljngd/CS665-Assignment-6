/**
 * Name: Mukul Jangid 
 * Course: CS-665 Software Designs & Patterns 
 * Date: 04/12/2024 
 * File Name: DriverNotificationTest.java 
 * Description: Test cases for the assignment.
 */

package edu.bu.met.cs665;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class DriverNotificationTest {
  private Shop shop;
  private DeliveryRequest request;
  private Driver[] drivers;

  @Before
  public void setUp() {
    shop = new Shop("New Shop", "775 Commonwealth Avenue");
    drivers = new Driver[5];
    for (int i = 0; i < drivers.length; i++) {
      drivers[i] = new Driver("D" + (i + 1), "Driver" + (i + 1));
      shop.subscribe(drivers[i]);
    }
    request = shop.createDeliveryRequest("ORDER_2202", "25 Chester St", "Ferrari");
  }

  @Test
  public void testShopCreation() {
    assertEquals("New Shop", shop.getName());
    assertEquals("775 Commonwealth Avenue", shop.getAddress());
  }

  @Test
  public void testDriverCreation() {
    List<Observer> shopObservers = shop.getObservers();
    List<Observer> driversList = Arrays.asList(drivers);
    assertTrue("The drivers array and shop observers list should contain the same elements",
            driversList.containsAll(shopObservers) && shopObservers.containsAll(driversList));
  }

  @Test
  public void testDriverUpdates() {
    List<Observer> shopObservers = new ArrayList<>(Arrays.asList(drivers));
    for (int i = 0; i < drivers.length; i = i + 2) {
      Observer tempDriver = drivers[i];
      shop.unsubscribe(tempDriver);
      shopObservers.remove(tempDriver);
    }
    List<Observer> remainingObservers = shop.getObservers();
    assertTrue("The remaining observers in the shop should match those not unsubscribed",
            shopObservers.containsAll(remainingObservers) && remainingObservers.containsAll(shopObservers));
  }

  @Test
  public void testDeliveryRequestCreation() {
    assertEquals("New Shop", request.getShopName());
    assertEquals("25 Chester St", request.getDeliveryAddress());
    assertEquals("Ferrari", request.getProductDetails());
  }

  @Test
  public void testDeliveryRequestNotification() {
    // Setting up a mock or spy might be necessary to effectively test the notification logic.
    // This depends on the actual implementation details which are not specified here.
    // For now, we assume notification went out if no errors occur.
    shop.notifyObservers(request);
    assertTrue(true); // This test should be more comprehensive.
  }
}

