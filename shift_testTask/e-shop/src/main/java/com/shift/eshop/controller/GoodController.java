package com.shift.eshop.controller;

import com.shift.eshop.model.goods.HardDrive;
import com.shift.eshop.model.goods.Notebook;
import com.shift.eshop.model.goods.PC;
import com.shift.eshop.model.goods.Screen;
import com.shift.eshop.service.HardDriveService;
import com.shift.eshop.service.NotebookService;
import com.shift.eshop.service.PCService;
import com.shift.eshop.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodController {

    @Autowired
    private HardDriveService hardDriveService;

    @Transactional
    @PostMapping(value = "/goods/hardDrive")
    public void addHardDrive(@RequestBody HardDrive hardDrive) {
        hardDriveService.addHardDrive(hardDrive);
    }

    @Transactional
    @PutMapping(value = "/goods/hardDrive/{id}")
    public void redactHardDrive(@RequestBody HardDrive hardDrive, @PathVariable(name = "id") Integer id) {
        hardDriveService.updateHardDrive(hardDrive, id);
    }

    @GetMapping(value = "/goods/hardDrive")
    public ResponseEntity<List<HardDrive>> getHardDriveGoods() {
        List<HardDrive> hardDrives = hardDriveService.getHardDriveGoods();

        if (hardDrives != null && !hardDrives.isEmpty()) {
            return new ResponseEntity<>(hardDrives, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/goods/hardDrive/{id}")
    public ResponseEntity<HardDrive> getHardDrive(@PathVariable(name = "id") Integer id) {
        HardDrive hardDrive = hardDriveService.getHardDrive(id);

        if (hardDrive != null) {
            return new ResponseEntity<>(hardDrive, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    private NotebookService notebookService;

    @Transactional
    @PostMapping(value = "/goods/notebook")
    public void addNotebook(@RequestBody Notebook notebook) {
        notebookService.addNotebook(notebook);
    }

    @Transactional
    @PutMapping(value = "/goods/notebook/{id}")
    public void redactNotebook(@RequestBody Notebook notebook, @PathVariable(name = "id") Integer id) {
        notebookService.updateNotebook(notebook, id);
    }

    @GetMapping(value = "/goods/notebook")
    public ResponseEntity<List<Notebook>> getNotebookGoods() {
        List<Notebook> notebooks = notebookService.getNotebookGoods();

        if (notebooks != null && !notebooks.isEmpty()) {
            return new ResponseEntity<>(notebooks, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/goods/notebook/{id}")
    public ResponseEntity<Notebook> getNotebook(@PathVariable(name = "id") Integer id) {
        Notebook notebook = notebookService.getNotebook(id);

        if (notebook != null) {
            return new ResponseEntity<>(notebook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    private PCService pcService;

    @Transactional
    @PostMapping(value = "/goods/pc")
    public void addPC(@RequestBody PC pc) {
        pcService.addPC(pc);
    }

    @Transactional
    @PutMapping(value = "/goods/pc/{id}")
    public void redactPC(@RequestBody PC pc, @PathVariable(name = "id") Integer id) {
        pcService.updatePC(pc, id);
    }

    @GetMapping(value = "/goods/pc")
    public ResponseEntity<List<PC>> getPCGoods() {
        List<PC> pcs = pcService.getPCGoods();

        if (pcs != null && !pcs.isEmpty()) {
            return new ResponseEntity<>(pcs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/goods/pc/{id}")
    public ResponseEntity<PC> getPC(@PathVariable(name = "id") Integer id) {
        PC pc = pcService.getPC(id);

        if (pc != null) {
            return new ResponseEntity<>(pc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Autowired
    private ScreenService screenService;

    @Transactional
    @PostMapping(value = "/goods/screen")
    public void addScreen(@RequestBody Screen screen) {
        screenService.addScreen(screen);
    }

    @Transactional
    @PutMapping(value = "/goods/screen/{id}")
    public void redactScreen(@RequestBody Screen screen, @PathVariable(name = "id") Integer id) {
        screenService.updateScreen(screen, id);
    }

    @GetMapping(value = "/goods/screen")
    public ResponseEntity<List<Screen>> getScreenGoods() {
        List<Screen> screens = screenService.getScreenGoods();

        if (screens != null && !screens.isEmpty()) {
            return new ResponseEntity<>(screens, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/goods/screen/{id}")
    public ResponseEntity<Screen> getScreen(@PathVariable(name = "id") Integer id) {
        Screen screen = screenService.getScreen(id);

        if (screen != null) {
            return new ResponseEntity<>(screen, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
