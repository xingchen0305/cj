package com.bupt626.repository;

import com.bupt626.domain.Asset;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Xtj on 2017/6/18.
 */
public interface AssetRepository  extends JpaRepository<Asset, String> {

}
