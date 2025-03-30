package com.example.testing_develop_gh_actions_caching.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Invoice {
  private String invoiceId;
  private String customerId;
  private LocalDate invoiceDate;
  private List<InvoiceLine> invoiceLines;
  private BigDecimal totalAmount;

  public String getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public LocalDate getInvoiceDate() {
    return invoiceDate;
  }

  public void setInvoiceDate(LocalDate invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  public List<InvoiceLine> getInvoiceLines() {
    return invoiceLines;
  }

  public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
    this.invoiceLines = invoiceLines;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }
}
