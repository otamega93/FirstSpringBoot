package hello.repositories;

import hello.models.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * Created by informatica on 14/12/15.
 */
@RepositoryRestResource
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    @RestResource(path="byName", rel = "byName")
    List<Person> findByName(@Param("name") String name);

    @RestResource(path="byLastName", rel = "byLastName")
    List<Person> findByLastName(@Param("lastName") String lastName);

    @RestResource(path="byNameAndLastName", rel = "byNameAndLastName")
    List<Person> findByNameAndLastName(@Param("name") String name,
                                              @Param("lastName") String lastName);

    //Prevents all  HTTP DELETE types
    //@RestResource(exported = false)
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id);

    //@RestResource(exported = false)
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Iterable<? extends Person> iterable);

    //@RestResource(exported = false)
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Person person);

    //@RestResource(exported = false)
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteAll();

    //Prevents either HTTP POSTS and PUTS
    //@RestResource(exported = false)
    @Override
    Person save(Person person);

}

