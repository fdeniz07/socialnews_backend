package com.batch130.controller;


import com.batch130.payload.request.UserRequest;
import com.batch130.payload.response.UserResponse;
import com.batch130.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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

    //Not:UpdateById()********************************
    @PutMapping("/update/{userId}")
    public ResponseEntity<UserResponse> update(@RequestBody @Valid UserRequest userRequest, @PathVariable Long userId){
        return ResponseEntity.ok(userService.update(userRequest, userId));


    }

    //Not:DeleteById()********************************
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<UserResponse> delete(@PathVariable Long userId){
        return ResponseEntity.ok(userService.delete(userId));
    }

    //Not:getMyProfile()********************************
    //NOT: lOGİN OLAN KULLANICIYI MI GETİR?
    @GetMapping("/getMyProfile")
    public ResponseEntity<UserResponse> getMyProfile(HttpServletRequest request){

        String username = request.getHeader("username");

        UserResponse user = userService.getMyProfile(username);
        return ResponseEntity.ok(user);


    }

    //Not:getAllFavoritesByEntryId********************************
    //Not:??????

















}
