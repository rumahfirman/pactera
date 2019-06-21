package com.firman.repositories;

import com.firman.domainobjects.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by firman on 6/20/19.
 */
public interface CityRepository extends CrudRepository<City, Long>
{
    /**
     * Case insensitive search for city based on the name.
     *
     * @param name
     * @return
     */
    @Query("select c from City c where UPPER(c.name) = UPPER(:name)")
    City findByName(String name);
}
