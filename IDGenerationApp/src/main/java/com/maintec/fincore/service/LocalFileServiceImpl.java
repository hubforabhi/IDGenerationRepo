package com.maintec.fincore.service;

import com.maintec.fincore.model.SaveSignatureRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.maintec.fincore.IDGenerationConstants.FILE_PATH_SEPARATOR;

@Service
@Slf4j
public class LocalFileServiceImpl implements FileService {

   @Value("${signature:image:location}")
   private String signatureImageLocation;

   @Override
   public boolean save(SaveSignatureRequestModel saveSignatureRequestModel) {
      boolean success = false;
      String basePath =
              signatureImageLocation + FILE_PATH_SEPARATOR;

      Path path  = Paths.get(basePath);
      try {
         if(!Files.exists(path)) Files.createDirectories(path);
         Files.copy(saveSignatureRequestModel.getTheFile().getInputStream(),
                 path.resolve(saveSignatureRequestModel.getImageUrl()),
                 StandardCopyOption.REPLACE_EXISTING);
         success = true;
      } catch (IOException e) {
         log.error(getClass().getName(), "LocalFileServiceImpl.save IOException ", e);
      } catch (Exception e)  {
         log.error(getClass().getName(), "LocalFileServiceImpl.save Exception ", e);
      }
      return success;
   }
}
