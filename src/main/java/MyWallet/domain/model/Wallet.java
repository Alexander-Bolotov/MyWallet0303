package MyWallet.domain.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Wallets")
public class Wallet implements Serializable {

    @JsonView(Transaction.class)
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonView(Transaction.class)
    @Column(name = "wallet", unique = true)
    private String wallet;


}
