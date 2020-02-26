package api.endpoints.filecontroller;

import java.time.OffsetDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * Representation of an CSV-File which will be sent as a JSON-File by the FileController
 * 
 * @author Dennis
 *
 */
@ApiModel(value = "FileRepresentation", discriminator = "type")
public class FileRepresentation {

	/**
	 * Java 8 - Way for Timestamps
	 */
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
