package MyWallet.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "typeOfTransaction")
public class TypeOfTransaction {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "typeOfTransaction")
    private String typeOfTransaction;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "typeOfTrans_transaction",
            joinColumns = @JoinColumn(name = "typeOfTransaction_id"),
            inverseJoinColumns= @JoinColumn(name = "transaction_id"))
    private List<Transaction> transactions = new ArrayList<>();

}
