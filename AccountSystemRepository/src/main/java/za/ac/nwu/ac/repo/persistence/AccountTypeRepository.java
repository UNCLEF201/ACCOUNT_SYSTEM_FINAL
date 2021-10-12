package za.ac.nwu.ac.repo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountType;



@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {


   @Query(value = "SELECT" +
           "     ACCOUNTTYPE_ID,"+
           "     ACCOUNTTYPE_NAME," +
           "     DATE_CREATED,"+
           "     MNEMONIC" +
           "  FROM" +
           "     ACCOUNT_TYPE" +
           " WHERE MNEMONIC = : mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);
}
