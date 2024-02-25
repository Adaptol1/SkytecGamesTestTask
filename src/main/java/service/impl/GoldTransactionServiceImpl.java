package service.impl;

import db.tables.GoldTransactionTable;
import dto.GoldTransaction;
import service.GoldTransactionService;

public class GoldTransactionServiceImpl implements GoldTransactionService
{
    private GoldTransactionTable transactionTable;
    @Override
    public void registerGoldTransaction (GoldTransaction transaction)
    {
        transactionTable.add(transaction);
    }
}
