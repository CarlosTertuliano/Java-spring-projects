package br.com.moments.services;

import br.com.moments.models.Moment;
import br.com.moments.models.MomentDTO;
import br.com.moments.repositories.MomentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MomentService {
    private final MomentRepository momentRepository;

    @Autowired
    public MomentService(MomentRepository momentRepository) {
        this.momentRepository = momentRepository;
    }

    public Moment searchMomentByTitle(String title){
        return this.momentRepository.findByTitle(title);
    }

    public List<Moment> getAllMoments(){
        return this.momentRepository.findAll();
    }

    public Optional<Moment> searchMomentById(Long idMoment){
        Optional<Moment> moment = this.momentRepository.findById(idMoment);
        if(moment.isPresent()) {
            return this.momentRepository.findById(idMoment);
        }
        return Optional.empty();
    }

    public Optional<Moment> removeMoment(Long idMoment){
        Optional<Moment> moment = this.momentRepository.findById(idMoment);
        if(moment.isPresent()) {
            this.momentRepository.deleteById(idMoment);
            return moment;
        }
        return Optional.empty();
    }

    public void createMoment(MomentDTO momentDTO) {
        LocalDate date = LocalDate.now();
        Moment moment = new Moment(momentDTO.getTitle(), momentDTO.getDescription(), momentDTO.getImage(), date, date);
        this.momentRepository.save(moment);
    }

    public Optional<Moment> editMoment(Optional<Moment> moment, MomentDTO momentDTO) {
        moment.get().setUpdateAtMoment(LocalDate.now());
        moment.get().setDescription(momentDTO.getDescription());
        moment.get().setImage(momentDTO.getImage());
        moment.get().setTitle(momentDTO.getTitle());
        this.momentRepository.save(moment.get());
        return moment;
    }
}
