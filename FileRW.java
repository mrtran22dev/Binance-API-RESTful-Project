package com.binance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

public class FileRW {
	
	public String filePath;
	public File fileName;
	int fileCount;
	
	FileRW () {
		filePath = "C:\\Users\\mt\\Desktop\\Code Test\\Java\\Binance";
		fileName = new File(filePath + "\\json.txt");
		fileCount = 0;
	}
	
	public void writeFile (String json) throws IOException {

		while (fileName.exists())  {									// if filename already exist, appends count # to file suffix 
			fileCount++;
			fileName = new File(filePath + "\\json" + fileCount + ".txt");
		}
		
		FileWriter fw = new FileWriter(fileName, true);	// 'true' parameter enables append to file
		BufferedReader br = new BufferedReader(new StringReader(json));
		//String json = conn.connect();				// experimenting with "json.split(System.getProperty("line.separator"));"
		
		while (true) {
			String line = br.readLine();
			if (line != null) {
				fw.write(line);
				fw.write("\r\n");
			} else {
				break;
			}
		}
	    br.close();
		fw.close();										// Need to close writing to file before parsing JSON file below 
	}
}