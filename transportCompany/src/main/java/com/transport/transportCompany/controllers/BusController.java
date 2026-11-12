package com.transport.transportCompany.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.transport.transportCompany.data.BusRepository;
import com.transport.transportCompany.models.Bus;

import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;


@Controller
@RequestMapping("/bus")
public class BusController {

    private final BusRepository busRepository;

    public BusController(BusRepository aBusRepository){
        busRepository = aBusRepository;
    }

    //READ ALL
    @GetMapping
    public String readAllBuses(Model model){
        model.addAttribute("bus", busRepository.findAll());
        return "busesList";
    }
   
    //CREATE
    @PostMapping
    public String insertBus(@RequestParam String company,
                            @RequestParam String licensePlate, @RequestParam Integer numSeats,
                            @RequestParam Integer hp, @RequestParam String powerSupply)
    {

        Bus bus = new Bus();
        bus.setCompany(company);
        bus.setLicensePlate(licensePlate);
        bus.setNumSeats(numSeats);
        bus.setHp(hp);
        bus.setPowerSupply(powerSupply);
        busRepository.save(bus);

        return "redirect:/bus";
    }


    @GetMapping("/{id}")
    public Bus getBus(@PathVariable Long id) {
        return busRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Bus not found"));
    }

    
    //DELETE
    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        busRepository.delete(getBus(id));
        return "redirect:/bus";
    }


    //UPDATE
    @PostMapping("/{id}")
    public String updateBus(@PathVariable Long id, @RequestParam String company,
                            @RequestParam String licensePlate, @RequestParam Integer numSeats,
                            @RequestParam Integer hp, @RequestParam String powerSupply)
    {
        Bus bus = getBus(id);
        bus.setCompany(company);
        bus.setLicensePlate(licensePlate);
        bus.setNumSeats(numSeats);
        bus.setHp(hp);
        bus.setPowerSupply(powerSupply);
        busRepository.save(bus);

        return "redirect:/bus";
    }

    @GetMapping("/update/{id}")
    public String getFormUpdate(@PathVariable Long id, Model model){
        var bus = getBus(id);
        model.addAttribute("bus", bus);
        return "form-update";
    }
}