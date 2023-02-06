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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.Collection;
import static com.dent.utils.ErrorHandlingUtil.handleValidationErrors;

@RestController
@RequestMapping("/users")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Collection<UserExposeDTO> findAll(@RequestParam(name = "type", required = false) UserType userType,
                                             @RequestParam(name = "role", required = false) Role role) {
        return userService.findAll(userType, role);
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

}
