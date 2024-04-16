/**
 * Name: Mukul Jangid 
 * Course: CS-665 Software Designs & Patterns 
 * Date: 04/12/2024 
 * File Name: Shop.java 
 * Description: This class encapsulates a shop's ability to manage its delivery system via
 * an observer pattern. The Shop, acting as the subject, can generate delivery requests and notify
 * all subscribed observers, typically delivery drivers. This pattern allows for efficient and
 * dynamic dispatching of delivery tasks to drivers as soon as a new request is made, ensuring a
 * scalable and responsive delivery system.
 */

package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Shop implements Observable {
  private static final Logger LOGGER = Logger.getLogger(Shop.class.getName());
  private List<Observer> observers = new ArrayList<>();

  private String name;
  private String address;

  public Shop(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public List<Observer> getObservers() {
    return observers;
  }

  public void setObservers(List<Observer> observers) {
    this.observers = observers;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public void subscribe(Observer observer) {
    if (observer == null) {
      throw new IllegalArgumentException("Observer cannot be null");
    }
    observers.add(observer);
    LOGGER.info("Driver subscribed: " + observer);
  }

  @Override
  public void unsubscribe(Observer observer) {
    observers.remove(observer);
    LOGGER.info("Driver unsubscribed: " + observer);
  }

  @Override
  public void notifyObservers(DeliveryRequest request) {
    observers.forEach(observer -> observer.update(request));
    LOGGER.info("Notified all drivers about new delivery request: " + request.getOrderId());
  }

  /**
   * Constructs and returns a new {@link DeliveryRequest} based on the provided parameters, and
   * notifies observers of the new request.
   *
   * @param orderId The unique identifier for the order.
   * @param deliveryAddress The destination address for delivery.
   * @param productDetails Details about the product.
   * @return The newly created delivery request.
   */
  public DeliveryRequest createDeliveryRequest(
      String orderId, String deliveryAddress, String productDetails) {
    DeliveryRequest request =
        new DeliveryRequest(orderId, this.name, deliveryAddress, productDetails);
    notifyObservers(request);
    return request;
  }
}
