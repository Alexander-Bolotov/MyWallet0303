package MyWallet.domain.dao;


import MyWallet.domain.model.Transaction;
import MyWallet.domain.model.TypeOfTransaction;
import MyWallet.domain.model.Wallet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

import java.util.List;


public interface TransactionDao {
    List<Transaction> getTransactionsByPeriod(Date dateFirst, Date dateLast);
    List<Transaction> getAllTransactions();
//    List<Transaction> getTransactionsByUser();
//    List<Transaction> getTransactionByType(TypeOfTransaction typeOfTransaction);
//    List<Transaction> getTransactionsByConsumptionWallet(Wallet wallet);
//    List<Transaction> getTransactionsByIncomeWallet(Wallet wallet);

}
