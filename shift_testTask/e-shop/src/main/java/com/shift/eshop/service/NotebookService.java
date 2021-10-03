package com.shift.eshop.service;

import com.shift.eshop.model.goods.Notebook;
import com.shift.eshop.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotebookService {
    @Autowired
    private NotebookRepository notebookRepository;

    public void addNotebook(Notebook notebook) {
        notebookRepository.save(notebook);
    }

    public void updateNotebook(Notebook notebook, Integer id) {
        Optional<Notebook> notebookOptional = notebookRepository.findById(id);

        if (notebookOptional.isPresent()) {
            notebook.setId(id);
            notebookRepository.deleteById(id);
            notebookRepository.save(notebook);
        }
    }

    public List<Notebook> getNotebookGoods() {
        return notebookRepository.findAll();
    }

    public Notebook getNotebook(Integer id) {
        return notebookRepository.getById(id);
    }
}
