package com.bupt626.repository;

import com.bupt626.domain.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Xtj on 2017/7/3.
 */
public interface AssetTypeRepository extends JpaRepository<AssetType,String > {
   /* @Query("select t from AssetType t where t.code =?1")
    AssetType findAllByCode(String code);*/
    AssetType findByCode(String code);
}
