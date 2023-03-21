package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/testGetMapping")
    public String testController() {
        return "Hello World" ;
    }
    @GetMapping("/{id}")
    public  String testControllerWithPathVariables(@PathVariable(required = false) int id){
        return "Hello World ID "+id;
    }
    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id){

        return "Hello World ID "+ id;
    }
    //http://localhost:8080/test/testRequestParam?id=12345
    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO TestRequestBodyDTO) {
        return "Hello World ID" + TestRequestBodyDTO.getId()+ "Message : " + TestRequestBodyDTO.getMessage();
    }
    @GetMapping("/testRequestParam1")
    public ResponseDTO<String> testControllerResponseBody(){
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        list.add("Hello World! I`'m hyeonyeong");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }
    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        list.add("Hello World! I`'m hyeonyeong");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.badRequest().body(response);
    }
}
