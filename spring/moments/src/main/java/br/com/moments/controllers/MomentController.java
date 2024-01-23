package br.com.moments.controllers;

import br.com.moments.models.Moment;
import br.com.moments.models.MomentDTO;
import br.com.moments.services.MomentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class MomentController {

    private final MomentService momentService;

    @Autowired
    public MomentController(MomentService momentService) {
        this.momentService = momentService;
    }

    @PostMapping("/moment")
    public ResponseEntity<Moment> saveMoment(@RequestBody @Valid MomentDTO momentDTO){
        this.momentService.createMoment(momentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/moment/{idMoment}")
    public ResponseEntity<Optional<Moment>> updateMoment(@PathVariable Long idMoment, @RequestBody @Valid MomentDTO momentDTO){
        Optional<Moment> moment = this.momentService.searchMomentById(idMoment);
        if (moment.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        moment = this.momentService.editMoment(moment, momentDTO);
        return new ResponseEntity<>(moment, HttpStatus.OK);
    }

    @GetMapping("/list-moments")
    public ResponseEntity<List<Moment>> getAllMoments(){
        return new ResponseEntity<>(this.momentService.getAllMoments(), HttpStatus.OK);
    }

    @GetMapping("/list-moments/{idMoment}")
    public ResponseEntity<Optional<Moment>> getMoment(@PathVariable long idMoment){
        Optional<Moment> moment = this.momentService.searchMomentById(idMoment);
        if(moment.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(moment, HttpStatus.OK);
    }

    @DeleteMapping("/moment/{idMoment}")
    public ResponseEntity<?> deleteMoment(@PathVariable long idMoment){
        Optional<Moment> moment = this.momentService.removeMoment(idMoment);
        if(moment.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Moment with id = " + idMoment + " has been deleted", HttpStatus.OK);

    }
}
