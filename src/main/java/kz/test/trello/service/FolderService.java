package kz.test.trello.service;

import kz.test.trello.model.Folder;
import kz.test.trello.repository.FolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderService {

    private final FolderRepository folderRepository;

    public List<Folder> getAllFolders() {
        return folderRepository.findAll();
    }

    public void addFolder(Folder folder) {
        folderRepository.save(folder);
    }

    public Folder getFolder(Long id) {
        return folderRepository.findById(id).orElse(null);
    }

}
