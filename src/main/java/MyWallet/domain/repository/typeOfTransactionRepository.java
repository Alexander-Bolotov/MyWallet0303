package MyWallet.domain.repository;

import MyWallet.domain.model.TypeOfTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface typeOfTransactionRepository extends JpaRepository<TypeOfTransaction, Long> {
}
