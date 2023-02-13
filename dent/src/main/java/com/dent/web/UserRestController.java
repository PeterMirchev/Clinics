package com.dent.web;
import com.dent.model.dto.expose.UserExposeDTO;
import com.dent.model.dto.seed.UserSeedDTO;
import com.dent.model.enums.Role;
import com.dent.model.enums.UserType;
import com.dent.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.Collection;
import static com.dent.utils.exception.ExceptionHandlingUtil.handleValidationErrors;

@RestController
@RequestMapping("/users")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/count")
    public Long count() {
        return userService.count();
    }

    @GetMapping()
    public Collection<UserExposeDTO> findAll(@RequestParam(name = "type", required = false) UserType userType,
                                             @RequestParam(name = "role", required = false) Role role) {
        return userService.findAll(userType, role);
    }

    @GetMapping("/{id:\\d+}")
    public UserExposeDTO findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<UserExposeDTO> create(@Valid @RequestBody UserSeedDTO userSeedDTO, Errors errors) {
        handleValidationErrors(errors);
        UserExposeDTO userExposeDTO = userService.create(userSeedDTO);
        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .pathSegment("/{id}")
                        .buildAndExpand(userExposeDTO.getId())
                .toUri())
                .body(userExposeDTO);
    }

    @PutMapping("/{id:\\d+}")
    public ResponseEntity<UserExposeDTO> update(@Validated @RequestBody UserSeedDTO userSeedDTO, @PathVariable("id") Long id) {
        UserExposeDTO userExposeDTO = userService.update(userSeedDTO, id);
        return ResponseEntity.ok(userExposeDTO);
    }

    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Successfully Deleted User.");
    }

}
