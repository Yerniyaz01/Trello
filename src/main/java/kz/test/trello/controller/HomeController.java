package kz.test.trello.controller;


import kz.test.trello.model.*;
import kz.test.trello.service.CommentService;
import kz.test.trello.service.FolderService;
import kz.test.trello.service.TaskCategoryService;
import kz.test.trello.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final FolderService folderService;
    private final TaskService taskService;
    private final TaskCategoryService taskCategoryService;
    private final CommentService commentService;


    @GetMapping(value = "/")
    public String homePage(Model model) {
        model.addAttribute("folders", folderService.getAllFolders());

        return "home-page";
    }

    @PostMapping(value = "/add-folder")
    public String addFolder(Folder folder) {
        folderService.addFolder(folder);

        return "redirect:/";
    }

    @GetMapping(value = "/folder-page/{id}")
    public String detailsFolder(@PathVariable Long id,
                                Model model){
        Folder folder = folderService.getFolder(id);
        model.addAttribute("folder",folder);

        List<TaskCategory> taskCategories =  taskCategoryService.getAllTaskCategories();
        taskCategories.removeAll(folder.getCategories());
        folderService.addFolder(folder);
        model.addAttribute("categories", taskCategories);


        return "folder-page";
    }

    @PostMapping(value = "/add-category")
    public String addCategory(@RequestParam Long folder_id,
                              @RequestParam Long category_id){
        Folder folder = folderService.getFolder(folder_id);
        TaskCategory taskCategory = taskCategoryService.getByID(category_id);
        folder.getCategories().add(taskCategory);
        folderService.addFolder(folder);

        return "redirect:folder-page/" +folder_id;
    }

    @PostMapping(value = "/delete-category")
    public String deleteCategory(@RequestParam Long folder_id,
                                 @RequestParam Long category_id){
        Folder folder = folderService.getFolder(folder_id);
        TaskCategory taskCategory = taskCategoryService.getByID(category_id);
        folder.getCategories().remove(taskCategory);
        folderService.addFolder(folder);

        return "redirect:folder-page/" +folder_id;
    }


}
