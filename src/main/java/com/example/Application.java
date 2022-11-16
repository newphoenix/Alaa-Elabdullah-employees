package com.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.Util.Constants;
import com.example.Util.CsvUtils;
import com.example.Util.OverlapUtils;
import com.example.model.Entry;
import com.example.service.EmployeeLongestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {

	public static void main(String[] args) throws URISyntaxException, IOException {

		Path path = Path.of(EmployeeLongestService.class.getResource("/data.csv").toURI());

		Map<Integer, List<Entry>> dataMap = CsvUtils.readCsv(Files.lines(path));

		String result = OverlapUtils.processDataFile(dataMap).stream().map(e -> String.join(Constants.COMMA, //
				e.getEmployeeId1().toString(), //
				e.getEmployeeId2().toString(), //
				e.getProjectId().toString(), //
				e.getDaysWorked().toString()))//
				.collect(Collectors.joining(Constants.NEW_LINE));

		log.info("\n Result is: \n{}", result);

		String timestamp = LocalDateTime.now().toString().replace(Constants.COLON, Constants.HYPHEN);
		Path filePath = Paths.get("output_" + timestamp  + ".csv");
		Files.writeString(filePath, Constants.HEADER);
		Files.writeString(filePath, result,StandardOpenOption.APPEND);

	}

}
