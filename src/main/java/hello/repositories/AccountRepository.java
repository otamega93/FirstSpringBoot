package hello.repositories;

import hello.models.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by informatica on 29/04/16.
 */
@RepositoryRestResource(path = "/accounts")
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    //Example route
    //http://127.0.0.2:9900/accounts/search/byUsername?username=
    @RestResource(path="byUsername", rel = "byUsername")
    Account findByUsername(@Param("username") String username);

    //@Override
    @RestResource
    Account save(Account account);

}
