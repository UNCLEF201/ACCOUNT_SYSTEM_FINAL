package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Account_Type")
public class AccountType implements Serializable {


    private Long accountTypeID;
    private String AccountTypeName;
    private LocalDate Date_created;

    private Set<AccountTransaction> AccountTransaction;

public AccountType()
{

}

public AccountType(long accountTypeID, String mnemonic, String AccountTypeName, LocalDate creation_Date)
{
    this.accountTypeID = accountTypeID;
    this.AccountTypeName = AccountTypeName;
    this.Date_created = creation_Date;
}

public AccountType(String mnemonic, String accountTypeName, LocalDate creation_Date)
{
    this.AccountTypeName = accountTypeName;

}
@Id
@SequenceGenerator(name = "AccountSystem_Seq", sequenceName = "AccountSystem.AccountSystem_SEQ",allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountSystem_SEQ")
@Column(name = "Account_Type_ID")
public long getAccountId() {return accountTypeID;}

@Column(name = "AccountTypeName")
public String getAccountTypeName(){return AccountTypeName;}


@Column(name = "creation_Date")
public LocalDate getCreation_Date(){return  Date_created;}

@OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY,mappedBy = "accountTypeID", orphanRemoval = true,cascade = CascadeType.PERSIST)
public Set<AccountTransaction>getAccountTransaction()
{
   return AccountTransaction;
}

public void setAccountTypeID(long accountTypeID)
{
    this.accountTypeID =accountTypeID;
}

public void setAccountTypeName(String accountTypeName)
{
    this.AccountTypeName = accountTypeName;
}

public void setDate_created(LocalDate creation_Date)
{
    this.Date_created = creation_Date;
}


@Override
public boolean equals(Object p)
{
    if (this == p)
    {
        return true;
    }
    if (p == null || getClass() != p.getClass())
    {
        return false;

    }
    AccountType that = (AccountType) p;
    return  Objects.equals(Date_created, that.Date_created) && Objects.equals (AccountTypeName, that.AccountTypeName);
}

@Override
public int hashCode()
{
    return Objects.hash(accountTypeID,AccountTypeName,Date_created);
}

@Override
public String toString()
{
    return "AccountType{" +
            "accountTypeID ='"+ accountTypeID + '\''+
            ",AccountTypeName='"+ AccountTypeName + '\'' +
            ", creation_Date=" + Date_created +
            '}';
}




}

