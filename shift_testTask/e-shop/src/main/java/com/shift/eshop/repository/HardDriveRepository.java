package com.shift.eshop.repository;

import com.shift.eshop.model.goods.HardDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDriveRepository extends JpaRepository<HardDrive, Integer> {}
