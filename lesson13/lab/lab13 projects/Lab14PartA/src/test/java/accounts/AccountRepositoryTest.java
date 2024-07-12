package accounts;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
// use junit not junit juptor
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

// test Account Repository class
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByAccountHolder() {
        // given
        Account account = new Account("123456", 100.0, "Frank Brown");
        testEntityManager.persist(account);
        testEntityManager.flush();
        // when
        Account found = accountRepository.findByAccountHolder(account.getAccountHolder());
        // then
        assertThat(
                found.getAccountHolder(),
                equalTo("Frank Brown")
        );

    }

}
