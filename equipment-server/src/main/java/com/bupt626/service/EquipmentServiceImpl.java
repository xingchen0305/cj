package com.bupt626.service;

import com.bupt626.domain.Equipment;
import com.bupt626.repository.EquipmentRepository;
import com.github.abel533.easyxls.EasyXls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by hexiuyu on 2017/1/20.
 */
@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository repository;

    @Override
    public void saveEquipment(Equipment equipment) {
        repository.save(equipment);
    }

    @Override
    public List uploadEquipmentFile(File file) throws Exception {
        try {
            return EasyXls.xls2List(this.getClass().getResource("/equipmentMap.xml").getPath(), file);
        } catch (Exception e) {
            throw new Exception("文件转换出错");
        }
    }

    public File convertMultipartFiletoFile(MultipartFile multipartFile) {
        File file = new File(multipartFile.getOriginalFilename());
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(multipartFile.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
