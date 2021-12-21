package by.academy.it.pojos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Bank_accounts")
@Getter
@Setter
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column(name = "bank_account_id")
    private String id;

    @Column(name = "account_number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    public BankAccount() {
    }

    public BankAccount(String number, Person owner) {
        this.number = number;
        this.owner = owner;
    }
}
