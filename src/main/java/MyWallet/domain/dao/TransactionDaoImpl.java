package MyWallet.domain.dao;

import MyWallet.domain.model.Transaction;
import MyWallet.domain.repository.TransactionRepository;
import MyWallet.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class TransactionDaoImpl implements TransactionDao {

    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public List<Transaction> getTransactionsByPeriod(Date dateFirst, Date dateLast) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
