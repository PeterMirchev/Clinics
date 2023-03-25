package com.dent.web;
import com.dent.model.dto.expose.WardExposeDTO;
import com.dent.model.dto.seed.WardSeedDTO;
import com.dent.service.WardService;
import com.dent.utils.common.CommonMessages;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.Collection;
import static com.dent.utils.exception.ExceptionHandlingUtil.handleValidationErrors;

@RestController
@RequestMapping("/wards")
public class WardRestController {
    private final WardService wardService;

    @Autowired
    public WardRestController(WardService wardService) {
        this.wardService = wardService;
    }

    @GetMapping("/count")
    public Long count(){
        return wardService.count();
    }

    @GetMapping()
    public Collection<WardExposeDTO> findAll(){
        return wardService.findAll();
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<WardExposeDTO> findById(@PathVariable("id") Long id) {
        WardExposeDTO wardExposeDTO = wardService.findById(id);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(wardExposeDTO.getId()).toUri())
                .body(wardExposeDTO);
    }

    @PostMapping()
    public ResponseEntity<WardExposeDTO> create(@Valid @RequestBody WardSeedDTO wardSeedDTO, Errors errors){
        handleValidationErrors(errors);
        WardExposeDTO wardExposeDTO = wardService.create(wardSeedDTO);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().pathSegment("{id}").buildAndExpand(wardExposeDTO.getId()).toUri())
                .body(wardExposeDTO);
    }

    @PutMapping("{id:\\d+}")
    public ResponseEntity<WardExposeDTO> update(@Valid @RequestBody WardSeedDTO wardSeedDTO, @PathVariable("id") Long id, Errors errors) {
        handleValidationErrors(errors);
        WardExposeDTO wardExposeDTO = wardService.update(wardSeedDTO, id);
        return ResponseEntity.ok(wardExposeDTO);
    }

    @DeleteMapping("{id:\\d+}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        wardService.deleteById(id);
        return ResponseEntity.ok("Successfully Deleted Ward.");
    }

    @PostMapping("/{id:\\d+}/wards")
    public ResponseEntity<WardExposeDTO> addUser(@PathVariable("id") Long wardId, @RequestParam(name = "userId") Long userId) {
        WardExposeDTO wardExposeDTO = wardService.findById(wardId);
        wardService.addUser(wardId, userId);
        return ResponseEntity.ok(wardExposeDTO);
    }

    @DeleteMapping("/{id:\\d+}/wards")
    public ResponseEntity<WardExposeDTO> removeUser(@PathVariable("id") Long wardId, @RequestParam(name = "userId") Long userId) {
        WardExposeDTO wardExposeDTO = wardService.findById(wardId);
        wardService.removeUser(wardId, userId);
        return ResponseEntity.ok(wardExposeDTO);
    }

}
