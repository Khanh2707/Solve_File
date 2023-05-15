package Model;

public class NotePad_model {
	private String fileName;
	private String fileContent;
	
	public NotePad_model() {
		this.fileName = "";
		this.fileContent = "";
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	
	
}
