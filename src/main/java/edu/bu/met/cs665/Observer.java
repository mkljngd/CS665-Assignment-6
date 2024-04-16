/**
 * Name: Mukul Jangid 
 * Course: CS-665 Software Designs & Patterns 
 * Date: 04/12/2024 
 * File Name: Observer.java 
 * Description: The Observer interface is part of the Observer Design Pattern.
 * It defines the `update` method that all observers must implement to receive updates.
 * This method is invoked when a DeliveryRequest is notified by the Observable.
 */

package edu.bu.met.cs665;

public interface Observer {
  void update(DeliveryRequest request);
}
