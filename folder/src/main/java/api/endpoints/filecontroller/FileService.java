package api.endpoints.filecontroller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

@Service
public class FileService {

	public String getFileContentAsString(String string) {

		return "Received String: " + string;
	}

	public FileRepresentation getValuesFromCSV(String path) throws IOException {

		return readCSV(path);
	}

	private FileRepresentation readCSV(String path) throws IOException {

		FileSystemResource file = new FileSystemResource(path);
		List<String> headers = new ArrayList<>();

		List<List<String>> content = new ArrayList<List<String>>();

		CSVParser csvParser = CSVFormat.EXCEL.withDelimiter(';')
				.withHeader("Index", "Attribute 1", "Attribute 2", "Attribute 3")
				.parse(new InputStreamReader(file.getInputStream()));
		int idx = 0;
		for (CSVRecord record : csvParser) {

			if (idx == 0) {
				headers = Arrays.asList(record.get(0), record.get(1), record.get(2), record.get(3));
				idx = 1;
			} else {
				List<String> row = Arrays.asList(record.get(0), record.get(1), record.get(2), record.get(3));
				content.add(row);
			}
		}

		OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

		return new FileRepresentation(content, headers, now);
	}

}
