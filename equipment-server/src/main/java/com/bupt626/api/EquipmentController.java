package com.bupt626.api;

import com.bupt626.domain.Equipment;
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

    //todo  add exception return to the client , think whether or not save the file
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

    @RequestMapping("/getUserInfo")
    public String getUserInfo(){
        return "棒极了！哈哈";
    }
}
