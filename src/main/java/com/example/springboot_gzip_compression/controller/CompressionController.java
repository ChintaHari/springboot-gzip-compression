package com.example.springboot_gzip_compression.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_gzip_compression.dto.Employee;

@RestController
public class CompressionController {
    
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        List<String> genders = Arrays.asList("Male", "Female", "Other");
        List<String> departments = Arrays.asList("HR", "Finance", "Engineering", "Sales", "Marketing");
        List<String> skills = Arrays.asList("Java", "Spring Boot", "SQL", "Kafka", "MongoDB");
        
        return IntStream.rangeClosed(1, 100000)
                        .mapToObj(i -> Employee.builder()
                                                .employeeId(i)
                                                .employeeName("Employee " + i)
                                                .employeeContactNumber(String.valueOf(new Random().nextLong(1000000000L)))
                                                .employeeAddress("Address " + i)
                                                .employeeGender(genders.get(new Random().nextInt(genders.size())))
                                                .employeeDepartment(departments.get(new Random().nextInt(departments.size())))
                                                .employeeSkills(skills.get(new Random().nextInt(skills.size())))
                                                .build())
                        .collect(Collectors.toList());
    }
}
