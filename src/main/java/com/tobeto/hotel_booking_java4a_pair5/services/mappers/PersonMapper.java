package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Person;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.person.GetAllPersonResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.person.GetByIdPersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "fullAddress", source = "address.fullAddress")
    GetAllPersonResponse getAllPersonResponseMap(Person person);

    List<GetAllPersonResponse> getAllPersonResponseListFromPerson(List<Person> persons);

    @Mapping(target = "fullAddress", source = "address.fullAddress")
    GetByIdPersonResponse getByIdPersonResponseFromPerson(Person person);
}
