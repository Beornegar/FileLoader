package api.endpoints.filecontroller;

import java.time.OffsetDateTime;
import java.util.List;

public class FileRepresentation {

	private OffsetDateTime timestamp;

	private List<String> headers;
	private List<List<String>> texts;

	public FileRepresentation() {
	}

	public FileRepresentation(List<List<String>> texts, List<String> headers, OffsetDateTime timestamp) {
		this.texts = texts;
		this.timestamp = timestamp;
		this.headers = headers;
	}

	public OffsetDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(OffsetDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public List<List<String>> getTexts() {
		return texts;
	}

	public void setTexts(List<List<String>> texts) {
		this.texts = texts;
	}

	public List<String> getHeaders() {
		return headers;
	}

	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}

}
