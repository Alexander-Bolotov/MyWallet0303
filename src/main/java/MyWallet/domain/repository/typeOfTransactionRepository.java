package MyWallet.domain.repository;

import MyWallet.domain.model.TypeOfTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface typeOfTransactionRepository extends JpaRepository<TypeOfTransaction, Long> {
    @Override
    List<TypeOfTransaction> findAll();
}
