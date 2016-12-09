package com.lesstif.jira.issue;

import java.io.File;
import java.io.IOException;

import com.lesstif.jira.JsonPrettyString;

import lombok.Data;

@Data
public class Issue extends JsonPrettyString{
	public String expand;
	public String id;
	public String self;
	public String key;
	
	private IssueFields fields = new IssueFields();

	public Issue addAttachment(String filePath) throws IOException {		
		addAttachment(new File(filePath));
		
		return this;
	}
	
	public Issue addAttachment(File file) throws IOException {	
		fields.addAttachment(file);	
		
		return this;
	}

	/**
	 * check attachment exist 
	 * 
	 * @return boolean true: issue have attachment, false: no attachment
	 */
	public boolean hasAttachments() {
		if (fields.getFileList() != null && fields.getFileList().size() > 0)
			return true;
		
		return false;
	}
       
        
}
