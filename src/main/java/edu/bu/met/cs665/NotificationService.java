/**
 * Name: Mukul Jangid 
 * Course: CS-665 Software Designs & Patterns 
 * Date: 04/12/2024 
 * File Name: NotificationService.java 
 * Description: The NotificationService class acts as the subject in the Observer Design Pattern.
 * It maintains a list of observers (Driver) that are subscribed to receive notifications. 
 * The class provides methods to add (subscribe) or remove (unsubscribe) observers from the 
 * notification list. When a new DeliveryRequest is made, the NotificationService notifies all
 * subscribed drivers by calling their notify method.
 */

package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class NotificationService implements Observable {
  private static final Logger LOGGER = Logger.getLogger(NotificationService.class.getName());
  private List<Observer> observers = new ArrayList<>();

  @Override
  public void subscribe(Observer observer) {
    if (observer == null) {
      throw new IllegalArgumentException("Observer cannot be null");
    }
    observers.add(observer);
    LOGGER.fine("Observer subscribed: " + observer);
  }

  @Override
  public void unsubscribe(Observer observer) {
    observers.remove(observer);
    LOGGER.fine("Observer unsubscribed: " + observer);
  }

  @Override
  public void notifyObservers(DeliveryRequest request) {
    for (Observer observer : observers) {
      observer.update(request);
      LOGGER.fine("Notified observer about request: " + request.getOrderId());
    }
  }
}
