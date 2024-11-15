package fr.caensup.td.demo.controllers;

import fr.caensup.td.demo.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import fr.caensup.td.demo.entity.TodoItem;



@Controller
@RequestMapping("/todos")
public class TodoController {
    private final TodoItemRepository todoItemRepository;
    public TodoController(@Autowired TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping({"/",""})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("todos/index");
        mv.addObject("todos", todoItemRepository.findAll());
        return mv;
    }

    @GetMapping("/create")
    public String create(){
        return "todos/create";
    }

    @PostMapping("/create")
    public String create(@RequestParam("name") String name, @RequestParam(value = "done", required = false) Boolean done) {
        TodoItem todoItem = new TodoItem();
        todoItem.setName(name);
        todoItem.setDone(done != null && done);
        todoItemRepository.save(todoItem);
        return "/todos";
    }

}
