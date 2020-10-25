package sk.jaroslavbeno.services;

import sk.jaroslavbeno.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonService {

    private static PersonService instance = null;
    private Map<Long, Person> persons = new HashMap<>();


    private PersonService() {
        Person person = new Person(1L, "Jaro", "Beno", 31);
        Person person2 = new Person(2L, "Fedor", "Beno", 31);
        Person person3 = new Person(3L, "Jaro", "Menno", 33);
        persons.put(person.getId(), person);
        persons.put(person2.getId(), person2);
        persons.put(person3.getId(), person3);
    }

    public static PersonService getPersonService() {
        if (instance == null) {
            return instance = new PersonService();
        }
        return instance;
    }

    public List<Person> getAllPersonsWithName(final String name) {
        return persons.values().stream()
                .filter(person -> person.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(persons.values());
    }

    public Person getPersonById(long id) {
        return persons.get(id);
    }

    public Person addPerson(Person person) {
        person.setId(persons.size() + 1L);
        persons.put(person.getId(), person);
        return getPersonById(person.getId());
    }

    public Person updatePerson(Person person) {
        persons.put(person.getId(), person);
        return getPersonById(person.getId());
    }

    public void deletePerson(Long personId) {
        persons.remove(persons.get(personId).getId());
    }
}
