package com.example.testing_develop_gh_actions_caching.controllers;

import com.example.testing_develop_gh_actions_caching.models.Invoice;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    Invoice invoice = invoices.stream().filter(i -> i.getInvoiceId().equals(id)).findFirst().orElse(null);

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
}
