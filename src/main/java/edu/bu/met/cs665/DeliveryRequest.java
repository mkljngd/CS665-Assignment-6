/**
 * Name: Mukul Jangid 
 * Course: CS-665 Software Designs & Patterns 
 * Date: 04/12/2024 
 * File Name: DeliveryRequest.java 
 * Description: The DeliveryRequest class encapsulates details about a delivery
 * order and represents the data that is being observed. When a new delivery request is created, it
 * can trigger notifications to interested observers.
 */

package edu.bu.met.cs665;

public class DeliveryRequest {
  private String orderId;
  private String shopName;
  private String deliveryAddress;
  private String productDetails;

  /**
   * Constructs a new delivery request with specified order details.
   *
   * @param orderId The unique identifier for the order.
   * @param shopName The name of the shop where the order was placed.
   * @param deliveryAddress The address where the product should be delivered.
   * @param productDetails Detailed description of the product(s) included in the delivery.
   */
  public DeliveryRequest(
      String orderId, String shopName, String deliveryAddress, String productDetails) {
    this.orderId = orderId;
    this.shopName = shopName;
    this.deliveryAddress = deliveryAddress;
    this.productDetails = productDetails;
  }

  // Getters
  public String getOrderId() {
    return orderId;
  }

  public String getShopName() {
    return shopName;
  }

  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  public String getProductDetails() {
    return productDetails;
  }
}
