package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Role;
import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import com.tobeto.hotel_booking_java4a_pair5.repositories.UserRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.UserService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.AuthMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.UserMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.user.AddUserRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetAllUserResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetByIdUserResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User add(AddUserRequest request) {
        User user = UserMapper.INSTANCE.userFromAddUserRequest(request);
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        roles.add(Role.GUEST);
        user.setAuthorities(roles);
        user = userRepository.save(user);

        return user;
    }

    @Override
    public Response delete(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(UserMessages.PERSON_NOT_FOUND));
        userRepository.deleteById(user.getId());

        return new SuccessResponse(UserMessages.PERSON_DELETED);
    }

    @Override
    public DataResponse<List<GetAllUserResponse>> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> response = UserMapper.INSTANCE.getAllUserResponseListFromUser(users);

        return new SuccessDataResponse<>(response, UserMessages.PERSON_LISTED);
    }

    @Override
    public User getById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(UserMessages.PERSON_NOT_FOUND));

        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new BusinessException(AuthMessages.AUTH_WRONG_CREDENTIALS));

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException(UserMessages.PERSON_NOT_FOUND));
    }
}
