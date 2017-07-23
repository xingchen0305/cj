package com.bupt.service;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengying on 2017/7/23.
 */

@Service
@Transactional
public class FTPService {
    public static final String FTP_IP = "10.105.242.65";
    public static final String FTP_PORT = "21";
    public static final String FTP_USERNAME = "ftpuser";
    public static final String FTP_PASSWORD = "mengying";
    public static final String FTP_IMAGE_PATH = "/home/ftpuser/www/images";
    public static final String IMAGE_PATH = "10.05.242.65/images/";
    public static String uploadFile(String localPath) {

        FTPClient ftp = new FTPClient();
        String fileName = null;
        try {
//			String localPath = "F:/test.txt";
            // 对目录的处理
            if (localPath.contains("/")) {
                fileName = localPath.substring(localPath.lastIndexOf("/") + 1);
            }
            FileInputStream input = new FileInputStream(new File(localPath));
            int reply;
            ftp.connect(FTP_IP, Integer.parseInt(FTP_PORT));//连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);//登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return "false";
            }
            ftp.changeWorkingDirectory(FTP_IMAGE_PATH);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.storeFile(fileName, input);//上传图片
            input.close();
            ftp.logout();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String imagePath = IMAGE_PATH + fileName;
        return imagePath;
    }
    private String ftpUpload(List<ByteArrayInputStream> inputStreamList) throws Exception{
        FTPClient ftp = new FTPClient();
        String path = null;
        StringBuilder imagePath = new StringBuilder();
        try {
            int reply;
            ftp.connect(FTP_IP, Integer.parseInt(FTP_PORT));//连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);//登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                 throw new IOException();
            }
            ftp.changeWorkingDirectory(FTP_IMAGE_PATH);
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            for(ByteArrayInputStream byteArrayInputStream:inputStreamList){
                String fileName = null;
                ftp.storeFile(fileName, byteArrayInputStream);//上传图片
                imagePath.append(FTP_IMAGE_PATH).append(fileName).append(",");
                byteArrayInputStream.close();
            }
            if (imagePath.length() >= 1){
                path = imagePath.substring(0,imagePath.length()-1);
            }
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return path;
    }
    public String saveImage(List<String> imageList){
        String path = null;
        List<ByteArrayInputStream> inputStreams = new ArrayList<>();
        StringBuilder imagePath = new StringBuilder("");
        for(String imageBase64 : imageList){
            String[] imageArray = imageBase64.split(",");
            if (imageArray.length >= 1){
                byte[] imageByte= Base64.decodeBase64(imageArray[1]);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageByte);
                    inputStreams.add(byteArrayInputStream);
                }
            }
            try {
                path = ftpUpload(inputStreams);
            }catch (Exception e){

            }
            return path;
        }
}
