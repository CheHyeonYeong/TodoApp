package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoEntity;
import com.example.demo.service.TodoService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;


@Builder
@RestController
@RequestMapping("todo")
public class ToDoController {

    @Autowired
    private TodoService service;
    @GetMapping("/test1")
    public ResponseEntity<?> testTodo1(){
        String str = service.testService();
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }

    //todo 메서드 작성하기

    @GetMapping("/testTodo")
    public ResponseEntity<?> testTodo (){
        //생성자 쓰기
        TodoDTO response
                =TodoDTO.builder().id("123").title("채현영").done(true).build();

        return ResponseEntity.ok().body(response);
    }
}
