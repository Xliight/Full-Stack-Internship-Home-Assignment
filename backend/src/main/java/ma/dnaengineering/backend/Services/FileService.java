package ma.dnaengineering.backend.Services;

import ma.dnaengineering.backend.Repository.FileRepo;
import ma.dnaengineering.backend.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {
    @Autowired
    public FileRepo fileRepo;
    public void saveFile(String fileName, MultipartFile file) throws IOException {
        File file1= new File();
        file1.setName(fileName);
        file1.setContent(file.getBytes());
        fileRepo.save(file1);
    }

    public File getFile(Long fileId) {
        return fileRepo.findById(fileId).orElse(null);
    }
}

