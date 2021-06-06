package AdvancedLevel;

import java.io.File;

public class FileSize {

	public static void main(String[] args) {

		String fileName = "src/main/resources/file.txt";

		File file = new File(fileName);

		long fileSize = file.length();

		System.out.format("File size in byte is : %d byte", fileSize);
	}

}
