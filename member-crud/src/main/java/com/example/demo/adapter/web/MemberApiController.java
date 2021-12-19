package com.example.demo.adapter.web;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<ResponseMember> create(@RequestBody RequestMember requestMember) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ResponseMember.convert(memberService.create(
                requestMember.getEmail(),
                requestMember.getUsername(),
                requestMember.getPassword(),
                requestMember.getBirthDay()
            )));
    }

    @PutMapping
    public ResponseEntity<ResponseMember> update(@RequestBody RequestMember requestMember) {
        return ResponseEntity.ok(ResponseMember.convert(memberService.update(
            requestMember.getEmail(),
            requestMember.getUsername(),
            requestMember.getPassword(),
            requestMember.getBirthDay()
        )));
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class RequestMember {

        private String email;

        private String username;

        private String password;

        private LocalDate birthDay;

    }


    @Value
    @JsonInclude(Include.NON_NULL)
    private static class ResponseMember {

        Long id;

        String email;

        String username;

        String password;

        LocalDate birthDay;

        public static ResponseMember convert(Member member) {
            return new ResponseMember(
                null,
                member.getEmail(),
                member.getUsername(),
                member.getPassword(),
                member.getBirthDay()
            );
        }

    }

}
