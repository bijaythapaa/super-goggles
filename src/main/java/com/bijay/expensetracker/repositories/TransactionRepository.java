package com.bijay.expensetracker.repositories;

import com.bijay.expensetracker.domain.Transaction;
import com.bijay.expensetracker.exceptions.EtBadRequestException;
import com.bijay.expensetracker.exceptions.EtResourceNotFoundException;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface TransactionRepository {

    List<Transaction> findAll(Integer userId, Integer categoryKey);

    Transaction findById(Integer userId, Integer categoryKey, Integer transactionId) throws EtResourceNotFoundException;

    Integer create(Integer userId, Integer categoryKey, Double amount, String note, Long transactionDate)
            throws EtBadRequestException;

    void update(Integer userId, Integer categoryKey, Integer transactionId, Transaction transaction)
            throws EtBadRequestException;

    void removeById(Integer userId, Integer categoryKey, Integer transactionId) throws EtResourceNotFoundException;

}
