package com.bupt.service;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by mengying on 2017/7/23.
 */

@Service
@Transactional
public class FTPService {
    public static boolean uploadFile(String localPath) {
        boolean message = false;
        FTPClient ftp = new FTPClient();
        try {
//			String localPath = "F:/test.txt";
            String fileName = null;
            // 对目录的处理
            if (localPath.contains("/")) {
                fileName = localPath.substring(localPath.lastIndexOf("/") + 1);
            }
            FileInputStream input = new FileInputStream(new File(localPath));
            int reply;
            ftp.connect("10.105.242.65", 21);//连接FTP服务器
            ftp.login("ftpuser", "mengying");//登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return message;
            }
            ftp.changeWorkingDirectory("/home/ftpuser/www/images");
            ftp.enterLocalPassiveMode();
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.storeFile(fileName, input);//上传图片
            input.close();
            ftp.logout();
            message = true;
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
        return message;
    }
}
