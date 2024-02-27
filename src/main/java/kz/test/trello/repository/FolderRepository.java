package kz.test.trello.repository;

import jakarta.transaction.Transactional;
import kz.test.trello.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface FolderRepository extends JpaRepository<Folder, Long> {

}
