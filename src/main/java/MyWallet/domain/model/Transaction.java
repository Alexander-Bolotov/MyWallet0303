package MyWallet.domain.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @JsonView(Transaction.class)
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonView(Transaction.class)
    @Column(name = "date")
    private Date date;

    @JsonView(Transaction.class)
    @ManyToOne
    private TypeOfTransaction typeOfTransaction;

    @JsonView(Transaction.class)
    @Column(name = "sumOfTransaction")
    private int sumOfTransaction;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TypeOfTransaction getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(TypeOfTransaction typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public int getSumOfTransaction() {
        return sumOfTransaction;
    }

    public void setSumOfTransaction(int sumOfTransaction) {
        this.sumOfTransaction = sumOfTransaction;
    }
}