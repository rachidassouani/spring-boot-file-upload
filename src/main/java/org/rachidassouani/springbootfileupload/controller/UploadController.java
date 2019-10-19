package org.rachidassouani.springbootfileupload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {

    Map<String, Object> result = new HashMap<>();

    @RequestMapping("/upload")
    public Map<String, Object> upload(@RequestParam("attach") MultipartFile file)throws IOException {

        // File info
        System.out.println("File name: "+file.getOriginalFilename());
        System.out.println("File type: "+file.getContentType());

        //Save to disk

        // here's where I want to save my file
        String myFilePath = "/home/rassouani/Documents/";
        file.transferTo(new File(myFilePath+ file.getOriginalFilename()));

        result.put("Success", true);
        return result;
    }

}
