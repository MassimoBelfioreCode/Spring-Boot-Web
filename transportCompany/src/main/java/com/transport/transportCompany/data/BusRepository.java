package com.transport.transportCompany.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transport.transportCompany.models.Bus;

import java.util.*;

public interface BusRepository extends JpaRepository<Bus, Long>{
   
}