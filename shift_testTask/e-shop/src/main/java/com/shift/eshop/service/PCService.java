package com.shift.eshop.service;

import com.shift.eshop.model.goods.PC;
import com.shift.eshop.repository.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PCService {
    @Autowired
    private PCRepository pcRepository;

    public void addPC(PC pc) {
        pcRepository.save(pc);
    }

    public void updatePC(PC pc, Integer id) {
        Optional<PC> pcOptional = pcRepository.findById(id);

        if (pcOptional.isPresent()) {
            pc.setId(id);
            pcRepository.deleteById(id);
            pcRepository.save(pc);
        }
    }

    public List<PC> getPCGoods() {
        return pcRepository.findAll();
    }

    public PC getPC(Integer id) {
        return pcRepository.getById(id);
    }
}
