package com.bupt626.controller;

import com.bupt626.entity.Equipment;
import com.bupt626.service.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created by hexiuyu on 2017/1/20.
 */
@RestController
@RequestMapping("/equipments")
public class EquipmentController {

    @Autowired
    private EquipmentServiceImpl equipmentService;

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile multipartFile) {

        File file = equipmentService.convertMultipartFiletoFile(multipartFile);
        try {
            List list = equipmentService.uploadEquipmentFile(file);
            for (Object object : list) {
                Equipment equipment = (Equipment) object;
                equipmentService.saveEquipment(equipment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            file.delete();
        }
    }
}
