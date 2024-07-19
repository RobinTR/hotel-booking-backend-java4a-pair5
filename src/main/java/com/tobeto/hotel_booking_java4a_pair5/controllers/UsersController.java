package com.tobeto.hotel_booking_java4a_pair5.controllers;


import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.UserService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.user.AddUserRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetAllUserResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetByIdUserResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.UserMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.UserMessages;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddUserRequest request) {
        userService.add(request);

        return new SuccessResponse(UserMessages.USER_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateUserRequest request) {
        userService.update(request);

        return new SuccessResponse(UserMessages.USER_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        userService.delete(id);

        return new SuccessResponse(UserMessages.USER_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllUserResponse>> getAll() {
        List<User> users = userService.getAll();
        List<GetAllUserResponse> userResponseList = UserMapper.INSTANCE.getAllUserResponseListFromUser(users);

        return new SuccessDataResponse<>(userResponseList, UserMessages.USER_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdUserResponse> getById(@PathVariable Integer getById) {
        User user = userService.getById(getById);
        GetByIdUserResponse getByIdUserResponse = UserMapper.INSTANCE.getByIdUserResponseFromUser(user);

        return new SuccessDataResponse<>(getByIdUserResponse, UserMessages.USER_LISTED);
    }
}
