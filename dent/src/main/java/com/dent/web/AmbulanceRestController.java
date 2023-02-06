package com.dent.web;
import com.dent.model.dto.expose.AmbulanceExposeDTO;
import com.dent.model.dto.seed.AmbulanceSeedDTO;
import com.dent.service.AmbulanceService;
import com.dent.utils.CommonMessages;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.Collection;
import static com.dent.utils.ErrorHandlingUtil.handleValidationErrors;

@RestController
@RequestMapping("/ambulances")
public class AmbulanceRestController {
    private final AmbulanceService ambulanceService;

    @Autowired
    public AmbulanceRestController(AmbulanceService ambulanceService) {
        this.ambulanceService = ambulanceService;
    }

    @GetMapping("/count")
    public Long count(){
        return ambulanceService.count();
    }

    @GetMapping()
    public Collection<AmbulanceExposeDTO> findAll() {
        return ambulanceService.findAll();
    }

    @GetMapping("/{id:\\d+}")
    public AmbulanceExposeDTO findById(@PathVariable("id") Long id){
        return ambulanceService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<AmbulanceExposeDTO> create(@Valid @RequestBody AmbulanceSeedDTO ambulanceSeedDTO, Errors errors){
        handleValidationErrors(errors);
        AmbulanceExposeDTO ambulanceExposeDTO = ambulanceService.create(ambulanceSeedDTO);
        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .pathSegment("{id}")
                        .buildAndExpand(ambulanceExposeDTO.getId()).toUri())
                .body(ambulanceExposeDTO);
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity<AmbulanceExposeDTO> update(@Valid @RequestBody AmbulanceSeedDTO ambulanceSeedDTO, @PathVariable("id") Long id, Errors errors){
        handleValidationErrors(errors);
        AmbulanceExposeDTO ambulanceExposeDTO = ambulanceService.update(ambulanceSeedDTO, id);
        return ResponseEntity.ok(ambulanceExposeDTO);
    }

    @DeleteMapping("{id:\\d+}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        ambulanceService.deleteById(id);
        return new ResponseEntity<>(CommonMessages.SUCCESSFULLY_DELETED_RESOURCE, HttpStatus.BAD_REQUEST);
    }
}
