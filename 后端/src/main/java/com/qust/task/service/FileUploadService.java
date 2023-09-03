package com.qust.task.service;

import com.qust.task.util.Msg;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Service
public class FileUploadService {
    public Msg upload(MultipartFile file){
        OutputStream os = null;
        InputStream inputStream = null;
        String fileName = null;
        int len;
        try {
            inputStream = file.getInputStream();
            fileName = UUID.randomUUID()+file.getOriginalFilename();
            String path = "D:\\重装前桌面代码内容\\暑期实训_2\\pictures\\medical";
            byte[] bs = new byte[1024];
            File tmpFile=new File(path);
            if (!tmpFile.exists()) {
                tmpFile.mkdirs();
            }
            os =new FileOutputStream(tmpFile.getPath()+File.separator+fileName);
            while((len=inputStream.read(bs))!=-1){
                os.write(bs,0,len);
            }
            os.close();
            inputStream.close();
        } catch (IOException e) {
            return Msg.fail().mess("上传失败");
        }
        String url = "http://localhost:8080/image/"+fileName;
        return Msg.success().mess("上传成功").data("url",url);


    }
}
