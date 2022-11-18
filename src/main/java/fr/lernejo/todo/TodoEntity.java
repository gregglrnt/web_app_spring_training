package fr.lernejo.todo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("todo")
class TodoEntity {
    @Id Long id;
    String message;
    String author;
}
