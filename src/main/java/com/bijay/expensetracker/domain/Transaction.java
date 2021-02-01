package com.bijay.expensetracker.domain;

public class Transaction {
    private Integer transaction_id;
    private Integer categoryKey;
    private Integer userId;
    private Double amount;
    private String note;
    private Long transactionDate;

    public Transaction(Integer transaction_id, Integer categoryKey, Integer userId,
                       Double amount, String note, Long transactionDate) {
        this.transaction_id = transaction_id;
        this.categoryKey = categoryKey;
        this.userId = userId;
        this.amount = amount;
        this.note = note;
        this.transactionDate = transactionDate;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Integer getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(Integer categoryKey) {
        this.categoryKey = categoryKey;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Long transactionDate) {
        this.transactionDate = transactionDate;
    }
}
