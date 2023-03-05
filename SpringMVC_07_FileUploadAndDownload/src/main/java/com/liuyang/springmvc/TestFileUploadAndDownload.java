package com.liuyang.springmvc;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
public class TestFileUploadAndDownload {

    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testFileUploadAndDownload(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取文件在服务器中的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //创建一字节数组
        byte[] data = new byte[fileInputStream.available()];
        //将数据读入到字节数组中
        fileInputStream.read(data);
        //创建请求头信息设置响应头信息
        MultiValueMap<String,String> httpHeaders = new HttpHeaders();
        //设置要下载的方式
        httpHeaders.add("Content-Disposition","attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus status = HttpStatus.OK;
        //创建响应对象
        ResponseEntity<byte[]> httpEntity = new ResponseEntity<byte[]>(data,httpHeaders,status);
        //关闭输入流
        fileInputStream.close();
        return  httpEntity;
    }

    @RequestMapping("/testUpload")
    public String testUploadFile(MultipartFile image,HttpSession session) throws IOException {
        //获取上传文件的文件名
        String filename = image.getOriginalFilename();
        //处理文件重名问题
        String name = filename.substring(filename.lastIndexOf("."));
        filename = UUID.randomUUID().toString().concat(name);
        //获取服务器中的照片路径
        ServletContext servletContext = session.getServletContext();
        String imgPaht = servletContext.getRealPath("/static/img");
        File file = new File(imgPaht);
        if (!(file.exists())){
            file.mkdir();
        }

        String finalPath = imgPaht +File.separator+filename;
        //实现上传功能
        image.transferTo(new File(finalPath));
        return "success";

    }


}
