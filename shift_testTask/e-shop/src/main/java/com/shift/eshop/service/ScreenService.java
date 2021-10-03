package com.shift.eshop.service;

import com.shift.eshop.model.goods.Screen;
import com.shift.eshop.repository.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenService {
    @Autowired
    private ScreenRepository screenRepository;

    public void addScreen(Screen screen) {
        screenRepository.save(screen);
    }

    public void updateScreen(Screen screen, Integer id) {
        Optional<Screen> screenOptional = screenRepository.findById(id);

        if (screenOptional.isPresent()) {
            screen.setId(id);
            screenRepository.deleteById(id);
            screenRepository.save(screen);
        }
    }

    public List<Screen> getScreenGoods() {
        return screenRepository.findAll();
    }

    public Screen getScreen(Integer id) {
        return screenRepository.getById(id);
    }
}
