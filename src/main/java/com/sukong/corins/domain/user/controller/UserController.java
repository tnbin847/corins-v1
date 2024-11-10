package com.sukong.corins.domain.user.controller;

import com.sukong.corins.domain.user.dto.SignUpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by 박 수 빈 on 24. 11. 9.
 */

@RestController
public class UserController {

    /**
     * 회원가입 화면 요청
     */
    @GetMapping("/sign-up")
    public ModelAndView signUp() {
        return new ModelAndView("corins/user/signup");
    }

    @PostMapping("/api/v1/user")
    public void createUser(@RequestBody @Valid final SignUpRequest signUpRequest) {

    }
}
