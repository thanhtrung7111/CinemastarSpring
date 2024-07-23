package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UploadImageService {

	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/img";

	public String upload(MultipartFile file) throws IOException {
		String originalFilename = file.getOriginalFilename();
		Path fileName = Paths.get(uploadDirectory, originalFilename);
		Files.write(fileName, file.getBytes());
		System.out.println(fileName.toString());
		return file.getOriginalFilename();
	}
}
