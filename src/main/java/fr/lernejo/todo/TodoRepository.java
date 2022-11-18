package fr.lernejo.todo;

import fr.lernejo.todo.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TodoRepository extends CrudRepository<TodoEntity, Long> {

}
