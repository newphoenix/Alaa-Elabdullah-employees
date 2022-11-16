package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.EmployeeLongestDto;
import com.example.service.EmployeeLongestService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("employees")
@AllArgsConstructor
public class EmployeeController {

	private EmployeeLongestService employeeLongestService;

	@PostMapping
	public ResponseEntity<List<EmployeeLongestDto>> processData(MultipartFile file) throws IOException {

		List<EmployeeLongestDto> EmployeeLongestList = employeeLongestService.processData(file);

		return ResponseEntity.ok(EmployeeLongestList);
	}

}
