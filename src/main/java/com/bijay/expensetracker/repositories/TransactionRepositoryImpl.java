package com.bijay.expensetracker.repositories;

import com.bijay.expensetracker.domain.Transaction;
import com.bijay.expensetracker.exceptions.EtBadRequestException;
import com.bijay.expensetracker.exceptions.EtResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private static final String SQL_CREATE = "INSERT INTO ET_TRANSACTIONS (TRANSACTION_ID, USER_ID, CATEGORY_KEY, " +
            "AMOUNT, NOTE, TRANSACTION_DATE) VALUES(NEXTVAL('ET_TRANSACTIONS_SEQ'), ?, ?, ?, ?, ?)";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Transaction> findAll(Integer userId, Integer categoryKey) {
        return null;
    }

    @Override
    public Transaction findById(Integer userId, Integer categoryKey, Integer transactionId) throws EtResourceNotFoundException {
        return null;
    }

    @Override
    public Integer create(Integer userId, Integer categoryKey, Double amount, String note, Long transactionDate) throws EtBadRequestException {
        return null;
    }

    @Override
    public void update(Integer userId, Integer categoryKey, Integer transactionId, Transaction transaction) throws EtBadRequestException {

    }

    @Override
    public void removeById(Integer userId, Integer categoryKey, Integer transactionId) throws EtResourceNotFoundException {

    }
}
