package cl.leclerck.service.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtilsBooks {
	private final Logger logger = LoggerFactory.getLogger(FileUtilsBooks.class);
    private static final String IMG_PATH = "src/main/resources/static/pictures/books/";
    private static final String FILE_PATH = "src/main/resources/static/books/";
    

    private String nameFile(MultipartFile file) {
        return UUID.randomUUID() + "_" + file.getOriginalFilename();
    }

    /*
     * sube el archivo a la carpeta static, retornando
     * el nombre del archivo subido, para poder
     * cargarlo en una base de datos.
     */
    public String uploadPicture(MultipartFile file) {
        String newName = nameFile(file);
        String picturePath = IMG_PATH + File.separator + newName;

        // ruta completa del archivo
        Path path = Paths.get(picturePath);
        try {
            byte[] fileBytes = file.getBytes();
            Files.write(path, fileBytes);
            logger.info("Saved picture: " + picturePath);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return newName;
    }
    public String uploadFile(MultipartFile file) {
    	String newName = nameFile(file);
    	String filePath = FILE_PATH + File.separator + newName;
    	
    	// ruta completa del archivo
    	Path path = Paths.get(filePath);
    	try {
    		byte[] fileBytes = file.getBytes();
    		Files.write(path, fileBytes);
    		logger.info("Saved file: " + filePath);
    	} catch (IOException e) {
    		logger.error(e.getMessage());
    	}
    	
    	return newName;
    }

    public boolean deleteFileByName(String name) {
        File file = new File(FILE_PATH + File.separator + name);
        return file.delete();
    }
    public boolean deletePictureByName(String name) {
    	File file = new File(IMG_PATH + File.separator + name);
    	return file.delete();
    }
}
