package com.example.testing_develop_gh_actions_caching.controllers;

import com.example.testing_develop_gh_actions_caching.models.Invoice;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

  private final List<Invoice> invoices = new ArrayList<>();

  @GetMapping("/invoices")
  public ResponseEntity<List<Invoice>> getInvoices() {
    return ResponseEntity.ok(invoices);
  }

  @GetMapping("/invoices/{id}")
  public ResponseEntity<Invoice> getInvoice(@PathVariable String id) {
    Invoice invoice =
        invoices.stream().filter(i -> i.getInvoiceId().equals(id)).findFirst().orElse(null);

    if (invoice == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(invoice);
  }

  @PostMapping("/invoices")
  public ResponseEntity<Invoice> createInvoice(Invoice invoice) {
    invoices.add(invoice);
    invoice.setInvoiceId(UUID.randomUUID().toString());
    return ResponseEntity.ok(invoice);
  }

  @PatchMapping("/invoices/{id}")
  public ResponseEntity<Invoice> updateInvoice(@PathVariable String id, Invoice invoice) {
    Invoice existingInvoice =
        invoices.stream().filter(i -> i.getInvoiceId().equals(id)).findFirst().orElse(null);

    if (existingInvoice == null) {
      return ResponseEntity.notFound().build();
    }

    existingInvoice.setTotalAmount(invoice.getTotalAmount());

    return ResponseEntity.ok(existingInvoice);
  }

  @DeleteMapping("/invoices/{id}")
  public ResponseEntity<Void> deleteInvoice(@PathVariable String id) {
    Invoice invoice =
        invoices.stream().filter(i -> i.getInvoiceId().equals(id)).findFirst().orElse(null);

    if (invoice == null) {
      return ResponseEntity.notFound().build();
    }

    invoices.remove(invoice);
    return ResponseEntity.noContent().build();
  }
}
