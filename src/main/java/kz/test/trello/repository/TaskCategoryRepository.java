package kz.test.trello.repository;

import jakarta.transaction.Transactional;
import kz.test.trello.model.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {

}
