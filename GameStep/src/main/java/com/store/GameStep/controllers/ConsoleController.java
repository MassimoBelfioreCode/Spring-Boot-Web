package com.store.GameStep.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.GameStep.data.ConsoleRepository;
import com.store.GameStep.models.Console;
import com.store.GameStep.models.Console.State;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/console")
public class ConsoleController {

    private final ConsoleRepository consoleRepository;

    public ConsoleController(ConsoleRepository aConsoleRepository){
        consoleRepository = aConsoleRepository;
    }

    @GetMapping
    public String getAllConsoles(Model model) {
        model.addAttribute("console", consoleRepository.findAll());
        return "consoles";
    }
    
    @PostMapping
    public String insertConsole(@RequestParam String name,
                                @RequestParam Double price, @RequestParam String color,
                                @RequestParam Integer availability, @RequestParam("state") State state)
    {
        var console = new Console();         
        console.setName(name);
        console.setPrice(price);
        console.setColor(color);
        console.setAvailability(availability);
        console.setState(state);
        consoleRepository.save(console);

        return "redirect:/console";
    }
    
    
    @GetMapping("/{id}")
    public Console searchConsole(@PathVariable Long id) {
        return consoleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "no Console founded"));
    }


    @PostMapping("/delete/{id}")
    public String deleteConsole(@PathVariable Long id) {
        consoleRepository.delete(searchConsole(id));
        return "redirect:/console";
    }
    

    @PostMapping("/{id}")
    public String updateConsole(@PathVariable Long id, @RequestParam String name,
                                @RequestParam Double price, @RequestParam String color,
                                @RequestParam Integer availability, @RequestParam("state") State state)
    {
        var console = searchConsole(id);        
        console.setName(name);
        console.setPrice(price);
        console.setColor(color);
        console.setAvailability(availability);
        console.setState(state);
        consoleRepository.save(console);

        return "redirect:/console";
    }

    
    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable Long id, Model model) {
        Console console = searchConsole(id);
        model.addAttribute("console", console);
        return "updateForm";
    }
    
}