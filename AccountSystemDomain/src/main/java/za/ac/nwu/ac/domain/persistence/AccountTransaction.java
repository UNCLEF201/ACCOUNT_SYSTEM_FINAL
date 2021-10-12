package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Account_transact")
public class AccountTransaction implements Serializable
{

    private Long transaction_ID;
    private Long membership_ID;
    private Long accountType_ID;
    private Long amount;
    private LocalDate transact_date;

    public AccountTransaction()
    {

    }

    public AccountTransaction(long transactionID,long accountTypeID,long membershipID, long amount,LocalDate transDate) {
        this.transaction_ID = transactionID;
        this.accountType_ID = accountTypeID;
        this.membership_ID = membershipID;
        this.amount = amount;
        this.transact_date = transDate;

    }

    @Id
    @SequenceGenerator(name = "AccountSystem_Seq", sequenceName = "AccountSystem.AccountSystem_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountSystem_SEQ")
    @Column(name = "transaction_ID")
    public Long getTransaction_ID()
    {
        return transaction_ID;
    }

    @Column(name ="accountType_ID")
    public Long getAccountType_ID()
    {
        return accountType_ID;
    }

    @Column(name = "membership_ID")
    public Long getMembership_ID()
    {
        return membership_ID;
    }
    @Column(name ="amount")
    public Long getAmount()
    {
        return amount;
    }
    @Column(name = "transact_Date")
    public LocalDate getTransact_date()
    {
        return transact_date;
    }


    @JoinColumn(name = "accountTypeID")
    public long getAccountId() {return accountType_ID;}

    public void setTransaction_ID(long transaction_ID)
    {
        this.transaction_ID = transaction_ID;
    }
    public void setMembership_ID(long membership_ID)
    {
        this.membership_ID = membership_ID;
    }
    public void setAccountType_ID(long accountType_ID)
    {
        this.accountType_ID = accountType_ID;
    }
    public void setAmount(long amount)
    {
        this.amount =amount;
    }

    public void setTransact_date(LocalDate transact_date)
    {
        this.transact_date = transact_date;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;

        }
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transaction_ID,that.transaction_ID) && Objects.equals(accountType_ID, that.accountType_ID) && Objects.equals(membership_ID, that.membership_ID)&& Objects.equals(amount, that.amount)&& Objects.equals(transact_date, that.transact_date);
    }

    @Override
    public String toString()
    {
        return "AccountTransaction{" +
                "accountTypeID ='"+ accountType_ID + '\''+
                "transactionID='" + transaction_ID + '\'' +
                ",membershipID='"+ membership_ID + '\'' +
                ", amount=" + amount +'\''+
                ",transact_Date=+" + transact_date +
                '}';
    }





    }
