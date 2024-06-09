package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.Person;
import com.tobeto.hotel_booking_java4a_pair5.repositories.PersonRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PersonService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.PersonMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.person.GetAllPersonResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.person.GetByIdPersonResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.PersonMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    @Override
    public Result delete(int id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException(PersonMessages.PERSON_NOT_FOUND));
        personRepository.deleteById(person.getId());

        return new SuccessResult(PersonMessages.PERSON_DELETED);
    }

    @Override
    public DataResult<List<GetAllPersonResponse>> getAll() {
        List<Person> persons = personRepository.findAll();
        List<GetAllPersonResponse> response = PersonMapper.INSTANCE.getAllPersonResponseListFromPerson(persons);

        return new SuccessDataResult<>(response, PersonMessages.PERSON_LISTED);
    }

    @Override
    public DataResult<GetByIdPersonResponse> getById(int id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException(PersonMessages.PERSON_NOT_FOUND));
        GetByIdPersonResponse response = PersonMapper.INSTANCE.getByIdPersonResponseFromPerson(person);

        return new SuccessDataResult<>(response, PersonMessages.PERSON_LISTED);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return personRepository.findByEmail(email).orElseThrow(() -> new RuntimeException(PersonMessages.PERSON_NOT_FOUND));
    }
}
