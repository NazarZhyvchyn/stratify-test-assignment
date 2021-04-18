package com.stratify.spring.files.excel.model;


import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "mock_data")
public class MockData {


  @Column(name = "customer_name")
  private String customerName;

  @Column(name = "booking_date")
  private LocalDateTime bookingDate;

  @Id
  @Column(name = "opportunity_id")
  private String opportunityId;

  @Column(name = "booking_type")
  private String bookingType;

  @Column(name = "total")
  private Double total;

  @Column(name = "account_executive")
  private String accountExecutive;

  @Column(name = "sales_organization")
  private String salesOrganization;

  @Column(name = "team")
  private String team;

  @Column(name = "product")
  private String product;



  @Column(name = "renewable")
  private String renewable;

  public MockData() {

  }

  public MockData(String customerName, LocalDateTime bookingDate, String opportunityId, String bookingType,
                  Double total, String accountExecutive, String salesOrganization, String team,
                  String product, String renewable) {
    this.customerName = customerName;
    this.bookingDate = bookingDate;
    this.opportunityId = opportunityId;
    this.bookingType = bookingType;
    this.total = total;
    this.accountExecutive = accountExecutive;
    this.salesOrganization = salesOrganization;
    this.team = team;
    this.product = product;
    this.renewable = renewable;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public LocalDateTime getBookingDate() {


    return bookingDate;
  }

  public void setBookingDate(LocalDateTime bookingDate) {

    this.bookingDate = bookingDate;
  }

  public String getOpportunityId() {
    return opportunityId;
  }

  public void setOpportunityId(String opportunityId) {
    this.opportunityId = opportunityId;
  }

  public String getBookingType() {
    return bookingType;
  }

  public void setBookingType(String bookingType) {
    this.bookingType = bookingType;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public String getAccountExecutive() {
    return accountExecutive;
  }

  public void setAccountExecutive(String accountExecutive) {
    this.accountExecutive = accountExecutive;
  }

  public String getSalesOrganization() {
    return salesOrganization;
  }

  public void setSalesOrganization(String salesOrganization) {
    this.salesOrganization = salesOrganization;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String renewable) {
    this.product = renewable;
  }

  public String getRenewable() {
    return renewable;
  }

  public void setRenewable(String renewable) {
    this.renewable = renewable;
  }
  @Override
  public String toString() {
    return "MockData{" +
            "customerName='" + customerName + '\'' +
            ", bookingDate='" + bookingDate + '\'' +
            ", opportunityId='" + opportunityId + '\'' +
            ", bookingType='" + bookingType + '\'' +
            ", total='" + total + '\'' +
            ", accountExecutive='" + accountExecutive + '\'' +
            ", salesOrganization='" + salesOrganization + '\'' +
            ", team='" + team + '\'' +
            ", renewable='" + product + '\'' +
            '}';
  }

}
