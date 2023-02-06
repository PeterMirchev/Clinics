package com.dent.web;
import com.dent.model.dto.expose.CityExposeDTO;
import com.dent.model.dto.seed.CitySeedDTO;
import com.dent.service.CityService;
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
@RequestMapping("/cities")
public class CityRestController {
    private final CityService cityService;

    @Autowired
    public CityRestController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/count")
    public Long count() {
        return cityService.count();
    }

    @GetMapping()
    public Collection<CityExposeDTO> findAll(){
        return cityService.findAll();
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<CityExposeDTO> findById(@PathVariable("id") Long id){
        CityExposeDTO cityExposeDTO = cityService.findById(id);
        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .pathSegment("{id}")
                .buildAndExpand(cityExposeDTO.getId()).toUri()).body(cityExposeDTO);
    }

    @PostMapping
    public ResponseEntity<CityExposeDTO> create(@Valid @RequestBody CitySeedDTO citySeedDTO, Errors errors) {
        handleValidationErrors(errors);
        CityExposeDTO cityExposeDTO = cityService.create(citySeedDTO);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(cityExposeDTO.getId()).toUri())
                .body(cityExposeDTO);
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity<CityExposeDTO> update(@Valid @RequestBody CitySeedDTO citySeedDTO, @PathVariable("id") Long id, Errors errors){
        handleValidationErrors(errors);
        CityExposeDTO cityExposeDTO = cityService.update(citySeedDTO, id);
        return ResponseEntity.ok(cityExposeDTO);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        cityService.deleteById(id);
        return new ResponseEntity<>(CommonMessages.SUCCESSFULLY_DELETED_RESOURCE, HttpStatus.OK);
    }

}
