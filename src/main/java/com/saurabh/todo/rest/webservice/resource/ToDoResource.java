package com.saurabh.todo.rest.webservice.resource;

import com.saurabh.todo.rest.webservice.dto.ToDo;
import com.saurabh.todo.rest.webservice.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins ={"http://localhost:4200","http://192.168.0.103:4200"})
@RestController
public class ToDoResource {
    @Autowired
    private ToDoService toDoService;
    @GetMapping(path = "/users/{userName}/todos/allToDos")
    public List<ToDo> allToDos(@PathVariable(name = "userName") String userName) throws InterruptedException {
        System.out.println("User name is "+userName);
        Thread.sleep(2000);
        return toDoService.findAll();
    }
    @GetMapping(path = "/users/{userName}/todos/{id}")
    public ToDo findToDo(@PathVariable(name = "userName") String userName,@PathVariable("id") long id) throws InterruptedException {
        ToDo toDo=toDoService.findById(id);
        System.out.println("Data found  "+toDo.toString());
        return toDo;
    }
    @DeleteMapping(path = "/users/{userName}/todos/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable("userName") String userName,@PathVariable("id") long id){
    ToDo todo=toDoService.deleteById(id);
    if(Objects.nonNull(todo))
        return ResponseEntity.noContent().build();
    return ResponseEntity.notFound().build();
    }

   // @UpdateM(path = "/users/{userName}/todos/{id}")
    @PutMapping(path = "/users/{userName}/todos/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable(name = "userName") String userName,
                           @PathVariable("id") long id,
                            @RequestBody ToDo todo) {
        System.out.println("UPDATE TODOS CALLED..........");
        todo.setUsername(userName);
        ToDo toDoUpdated=toDoService.save(todo);
        System.out.println("Data updated  "+toDoUpdated.toString());
        return new ResponseEntity<ToDo>(todo,HttpStatus.OK);
    }

    // @UpdateM(path = "/users/{userName}/todos/{id}")
    @PostMapping(path = "/users/{userName}/todos")
    public ResponseEntity<Void> saveToDo(@PathVariable(name = "userName") String userName,
                                           @PathVariable("id") long id,
                                           @RequestBody ToDo todo) {
        ToDo createdToDo=toDoService.save(todo);
        System.out.println("Data saved  "+createdToDo.toString());

       URI uri= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(createdToDo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
