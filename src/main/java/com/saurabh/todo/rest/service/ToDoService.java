package com.saurabh.todo.rest.service;

import com.saurabh.todo.rest.dto.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class ToDoService {

    private static List<ToDo> listOfToDos=new ArrayList<>();
    private static long idCounter=0;
    static {
        listOfToDos.add(new ToDo(++idCounter,"saurabh","OOPS concepts Advanced",new Date(),true));
        listOfToDos.add(new ToDo(++idCounter,"saurabh","Java 8 new features",new Date(),false));
        listOfToDos.add(new ToDo(++idCounter,"saurabh","OOPS concepts",new Date(),false));
        listOfToDos.add(new ToDo(++idCounter,"saurabh","Memory & JVM Internals\"",new Date(),false));
        listOfToDos.add(new ToDo(++idCounter,"saurabh","Threading",new Date(),false));
        listOfToDos.add(new ToDo(++idCounter,"saurabh","Concurrency",new Date(),false));
        listOfToDos.add(new ToDo(++idCounter,"saurabh","Testing",new Date(),true));
        listOfToDos.add(new ToDo(++idCounter,"saurabh","Design Patterns",new Date(),false));
        listOfToDos.add(new ToDo(++idCounter,"saurabh","Case Studies",new Date(),false));
    }

    public List<ToDo> findAll(){
        listOfToDos.forEach(System.out::println);
        return listOfToDos;
    }

    public ToDo findById(long id){
       //return listOfToDos.stream().map(toDo -> {toDo.getId()==id}).findFirst();
        for(ToDo toDo:listOfToDos){
            if(toDo.getId()==id)
                return toDo;
        }
        return null;
    }
     public ToDo deleteById(long id){
        ToDo toDo=findById(id);
     /*   if(listOfToDos.remove(toDo)) {
            return toDo;
        }else {
            return null;
        }*/
    return listOfToDos.remove(toDo)?toDo:null;
    }

    public ToDo save(ToDo toDo){
        if(toDo.getId()==-1){
            toDo.setId(++idCounter);
            listOfToDos.add(toDo);
        }else{
            deleteById(toDo.getId());
            listOfToDos.add(new ToDo(toDo.getId(),toDo.getUsername(),toDo.getDescription(),toDo.getTargetDate(),toDo.isDone()));
        }
        return toDo;
    }
}
