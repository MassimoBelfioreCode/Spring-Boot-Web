package com.store.GameStep.data;

import com.store.GameStep.models.Console;
import com.store.GameStep.models.Console.State;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsoleRepository extends JpaRepository<Console, Long>{
    List<Console> cList = new ArrayList<>();
    List<Console> findByName(String name);
    List<Console> findByState(State state);
    List<Console> findByPriceLessThan(Double price);
}