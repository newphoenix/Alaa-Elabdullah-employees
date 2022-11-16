package com.example.Util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import com.example.model.Entry;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvUtils {

	public static Map<Integer, List<Entry>> readCsv(Stream<String> stream) {

		Map<Integer, List<Entry>> dataMap = new HashMap<>();

		try {

			stream.forEach(e -> {

				String[] row = e.split(Constants.COMMA);
				Integer projectId = Integer.valueOf(row[1].trim());

				Entry entry = Entry.builder()//
						.empId(Integer.valueOf(row[0].trim()))//
						.projectId(projectId)//
						.dateFrom(Constants.NULL.equalsIgnoreCase(row[2]) ? LocalDate.now() : LocalDate.parse(row[2]))//
						.dateTo(Constants.NULL.equalsIgnoreCase(row[3]) ? LocalDate.now() : LocalDate.parse(row[3]))//
						.build();

				dataMap.compute(projectId, (key, val) -> {

					if (Objects.nonNull(val)) {
						val.add(entry);
					} else {
						val = new ArrayList<Entry>(List.of(entry));
					}

					return val;

				});

			});

		} catch (Exception e) {
			log.error("Error reading csv file", e);
		}

		return dataMap;
	}

}
