package com.batch130.controller;

import com.batch130.payload.request.UserRequest;
import com.batch130.payload.response.UserResponse;
import com.batch130.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //Not:Add***************************************
    @PostMapping("/add")
    public ResponseEntity<UserResponse> add(@RequestBody @Valid UserRequest userRequest){

        return ResponseEntity.ok(userService.add(userRequest));

    }

    //Not:getAll(pageable)********************************
    @GetMapping("/getAll")
    public Page<UserResponse> getAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "sort") String sort,
            @RequestParam(value = "type") String type
    ){
        return userService.getAll(page, size, sort, type);
    }

    //Not:getById()********************************
    @GetMapping("/getById/{userId}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getById(userId));
    }

















}
