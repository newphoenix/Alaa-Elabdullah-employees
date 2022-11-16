package com.example.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Entry {

	private Integer empId;
	private Integer projectId;
	private LocalDate dateFrom;
	private LocalDate dateTo;
}
