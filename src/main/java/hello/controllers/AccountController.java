package hello.controllers;

import hello.models.Account;
import hello.repositories.AccountRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Created by informatica on 29/04/16.
 */
@RepositoryRestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        //do something fancy
        System.out.println("CONTROLLER");
        System.out.println("ACCOUNT: " + account.getAuthorities() + ". USERNAME: " + account.getUsername() + ". PASS: " + account.getPassword());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        System.out.println("NEW PASS: " + account.getPassword());
        accountRepository.save(account);
        return new ResponseEntity<Account>(HttpStatus.OK);
    }

}
