package com.bupt626.service;

import com.bupt626.entity.Equipment;

import java.io.File;
import java.util.List;

/**
 * Created by hexiuyu on 2017/1/20.
 */
public interface EquipmentService {
    void saveEquipment(Equipment equipment);

    List uploadEquipmentFile(File file) throws Exception;
}
