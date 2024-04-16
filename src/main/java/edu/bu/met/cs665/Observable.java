/**
 * Name: Mukul Jangid 
 * Course: CS-665 Software Designs & Patterns 
 * Date: 04/12/2024 
 * File Name: Observable.java 
 * Description: The Observable interface is part of the Observer Design Pattern.
 * It provides methods to subscribe and unsubscribe observers and to notify them
 * of any changes by sending a DeliveryRequest. This interface is implemented by
 * classes that maintain a list of observers and notify them of events.
 */

package edu.bu.met.cs665;

public interface Observable {
  void subscribe(Observer observer);

  void unsubscribe(Observer observer);

  void notifyObservers(DeliveryRequest request);
}
