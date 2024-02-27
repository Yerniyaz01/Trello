package kz.test.trello.service;

import kz.test.trello.model.TaskCategory;
import kz.test.trello.repository.TaskCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskCategoryService {

    private final TaskCategoryRepository taskCategoryRepository;

    public List<TaskCategory> getAllTaskCategories() {
        return taskCategoryRepository.findAll();
    }

    public TaskCategory getByID(Long id) {
        return taskCategoryRepository.findById(id).orElse(null);
    }



}
