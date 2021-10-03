package com.shift.eshop.service;

import com.shift.eshop.model.goods.HardDrive;
import com.shift.eshop.repository.HardDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HardDriveService {
    @Autowired
    private HardDriveRepository hardDriveRepository;

    public void addHardDrive(HardDrive hardDrive) {
        hardDriveRepository.save(hardDrive);
    }

    public void updateHardDrive(HardDrive hardDrive, Integer id) {
        Optional<HardDrive> hardDriveOptional = hardDriveRepository.findById(id);

        if (hardDriveOptional.isPresent()) {
            hardDrive.setId(id);
            hardDriveRepository.deleteById(id);
            hardDriveRepository.save(hardDrive);
        }
    }

    public List<HardDrive> getHardDriveGoods() {
        return hardDriveRepository.findAll();
    }

    public HardDrive getHardDrive(Integer id) {
        return hardDriveRepository.getById(id);
    }
}
