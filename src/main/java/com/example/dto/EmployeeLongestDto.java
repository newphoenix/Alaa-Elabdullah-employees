package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeLongestDto {

	private Integer employeeId1;
	private Integer employeeId2;
	private Integer projectId;
	private Integer daysWorked;
}
