package com.example.testing_develop_gh_actions_caching.models;

public class InvoiceLine {
  private String invoiceLineId;
  private String productId;
  private double quantity;
  private double price;
  private double amount;

  public String getInvoiceLineId() {
    return invoiceLineId;
  }

  public void setInvoiceLineId(String invoiceLineId) {
    this.invoiceLineId = invoiceLineId;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }
}
