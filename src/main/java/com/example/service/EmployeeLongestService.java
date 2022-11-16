package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Util.CsvUtils;
import com.example.Util.OverlapUtils;
import com.example.dto.EmployeeLongestDto;
import com.example.model.Entry;

@Service
public class EmployeeLongestService {

	public List<EmployeeLongestDto> processData(MultipartFile csvFile) throws IOException{
		
		if(Objects.isNull(csvFile)) {
			return Collections.emptyList();
		}

		Stream<String> data = new BufferedReader(
				new InputStreamReader(csvFile.getInputStream(), StandardCharsets.UTF_8)).lines();

		Map<Integer, List<Entry>> dataMap = CsvUtils.readCsv(data);
		List<EmployeeLongestDto> result = OverlapUtils.processDataFile(dataMap);
				
		return result;
	}

}
