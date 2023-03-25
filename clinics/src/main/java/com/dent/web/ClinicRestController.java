package com.dent.web;
import com.dent.model.dto.expose.ClinicExposeDTO;
import com.dent.model.dto.seed.ClinicSeedDTO;
import com.dent.service.ClinicService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.Collection;
import java.util.stream.Collectors;
import static com.dent.utils.exception.ExceptionHandlingUtil.handleValidationErrors;

@RestController
@RequestMapping("/clinics")
public class ClinicRestController {
    private final ClinicService clinicService;
    private final ModelMapper modelMapper;

    public ClinicRestController(ClinicService clinicService, ModelMapper modelMapper) {
        this.clinicService = clinicService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/count")
    public Long count(){
        return clinicService.count();
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<ClinicExposeDTO> findById(@PathVariable("id") Long id) {
        ClinicExposeDTO clinicExposeDTO = clinicService.findById(id);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(clinicExposeDTO.getId()).toUri())
                .body(clinicExposeDTO);
    }

    @GetMapping()
    public Collection<ClinicExposeDTO> findAll() {
        return clinicService.findAll()
                .stream()
                .map(dto -> modelMapper.map(dto, ClinicExposeDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<ClinicExposeDTO> create(@Valid @RequestBody ClinicSeedDTO clinicSeedDTO, Errors errors) {
        handleValidationErrors(errors);
        ClinicExposeDTO clinicExposeDTO = clinicService.create(clinicSeedDTO);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(clinicExposeDTO.getId()).toUri())
                .body(clinicExposeDTO);
    }

    @PutMapping("{id:\\d+}")
    public ResponseEntity<ClinicExposeDTO> update(@Valid @RequestBody ClinicSeedDTO clinicSeedDTO, @PathVariable("id") Long id, Errors errors) {
        handleValidationErrors(errors);
        ClinicExposeDTO clinicExposeDTO = clinicService.update(clinicSeedDTO, id);
        return ResponseEntity.ok(clinicExposeDTO);
    }

    @PostMapping("/{id:\\d+}/ambulances")
    public ResponseEntity<ClinicExposeDTO> addAmbulance(@PathVariable("id") Long clinicId, @RequestParam(name = "ambulanceId") Long ambulanceId) {
        ClinicExposeDTO clinicExposeDTO = clinicService.findById(clinicId);
        clinicService.addAmbulance(clinicId, ambulanceId);
        return ResponseEntity.ok(clinicExposeDTO);
    }

    @DeleteMapping("/{id:\\d+}/ambulances")
    public ResponseEntity<ClinicExposeDTO> removeAmbulance(@PathVariable("id") Long clinicId, @RequestParam(name = "ambulanceId") Long ambulanceId) {
        ClinicExposeDTO clinicExposeDTO = clinicService.findById(clinicId);
        clinicService.removeAmbulance(clinicId, ambulanceId);
        return ResponseEntity.ok(clinicExposeDTO);
    }

    @DeleteMapping("{id:\\d+}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        clinicService.deleteById(id);
        return ResponseEntity.ok("Successfully Deleted Clinic.");
    }

}
