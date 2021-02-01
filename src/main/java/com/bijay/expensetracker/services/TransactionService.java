package com.bijay.expensetracker.services;

import com.bijay.expensetracker.domain.Transaction;
import com.bijay.expensetracker.exceptions.EtBadRequestException;
import com.bijay.expensetracker.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface TransactionService {

    List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId);

    Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId)
            throws EtResourceNotFoundException;

    Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate)
            throws EtBadRequestException;

    void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction)
            throws EtBadRequestException;

    void removeTransaction(Integer userId, Integer categoryId, Integer transactionId)
            throws EtResourceNotFoundException;
}
