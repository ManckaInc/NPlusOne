package vk.NPlusOne.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vk.NPlusOne.practice.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
