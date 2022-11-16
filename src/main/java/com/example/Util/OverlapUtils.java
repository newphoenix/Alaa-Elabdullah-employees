package com.example.Util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.example.dto.EmployeeLongestDto;
import com.example.model.Entry;

public class OverlapUtils {

	public static List<EmployeeLongestDto> processDataFile(Map<Integer, List<Entry>> dataMap) {

		List<EmployeeLongestDto> EmployeeLongestList = new ArrayList<>();

		dataMap.values().forEach(list -> {

			List<EmployeeLongestDto> tmp = new ArrayList<>();

			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					Entry emp1 = list.get(i);
					Entry emp2 = list.get(j);

					if (isOverlapping(emp1, emp2)) {
						int overlapDays = overlappingDays(emp1, emp2);
						EmployeeLongestDto employeeLongestDto = EmployeeLongestDto.builder()//
								.employeeId1(emp1.getEmpId())//
								.employeeId2(emp2.getEmpId())//
								.projectId(emp1.getProjectId())//
								.daysWorked(overlapDays)//
								.build();
						tmp.add(employeeLongestDto);
					}
				}
			}

			EmployeeLongestDto longestPair = Collections.max(tmp,
					Comparator.comparing(EmployeeLongestDto::getDaysWorked));
			EmployeeLongestList.add(longestPair);

		});

		return EmployeeLongestList;
	}

	private static int overlappingDays(Entry emp1, Entry emp2) {
		LocalDate date1 = emp1.getDateFrom().isBefore(emp2.getDateFrom()) ? emp2.getDateFrom() : emp1.getDateFrom();

		LocalDate date2 = emp1.getDateTo().isBefore(emp2.getDateTo()) ? emp1.getDateTo() : emp2.getDateTo();

		return (int) Math.abs(ChronoUnit.DAYS.between(date1, date2));
	}

	private static boolean isOverlapping(Entry employee1, Entry employee2) {
		return (employee1.getDateFrom().isBefore(employee2.getDateTo())
				|| employee1.getDateFrom().isEqual(employee2.getDateTo()))
				&& (employee1.getDateTo().isAfter(employee2.getDateFrom())
						|| employee1.getDateTo().isEqual(employee2.getDateFrom()));
	}

}
