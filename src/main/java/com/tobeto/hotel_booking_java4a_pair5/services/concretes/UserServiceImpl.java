package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import com.tobeto.hotel_booking_java4a_pair5.repositories.UserRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.UserService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.UserMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetAllUserResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetByIdUserResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public Result delete(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(UserMessages.PERSON_NOT_FOUND));
        userRepository.deleteById(user.getId());

        return new SuccessResult(UserMessages.PERSON_DELETED);
    }

    @Override
    public DataResult<List<GetAllUserResponse>> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> response = UserMapper.INSTANCE.getAllUserResponseListFromUser(users);

        return new SuccessDataResult<>(response, UserMessages.PERSON_LISTED);
    }

    @Override
    public DataResult<GetByIdUserResponse> getById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(UserMessages.PERSON_NOT_FOUND));
        GetByIdUserResponse response = UserMapper.INSTANCE.getByIdUserResponseFromUser(user);

        return new SuccessDataResult<>(response, UserMessages.PERSON_LISTED);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException(UserMessages.PERSON_NOT_FOUND));
    }
}
