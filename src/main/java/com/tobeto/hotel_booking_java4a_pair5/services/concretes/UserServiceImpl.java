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
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetAllUserResponse;
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
    public User update(UpdateUserRequest request) {
        User userOld = userRepository.findById(request.getId()).orElseThrow(() -> new BusinessException(UserMessages.USER_NOT_FOUND));
        User user = UserMapper.INSTANCE.userFromUpdateUserRequest(request);
        user.setPassword(userOld.getPassword());
        user.setAuthorities(userOld.getAuthorities());
        user = userRepository.save(user);

        return user;
    }

    @Override
    public Response delete(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(UserMessages.USER_NOT_FOUND));
        userRepository.deleteById(user.getId());

        return new SuccessResponse(UserMessages.USER_DELETED);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(UserMessages.USER_NOT_FOUND));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new BusinessException(AuthMessages.AUTH_WRONG_CREDENTIALS));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException(UserMessages.USER_NOT_FOUND));
    }
}
