package com.dent.web;

import com.dent.model.dto.Credentials;
import com.dent.model.dto.LoginResponse;
import com.dent.model.dto.expose.UserExposeDTO;
import com.dent.model.entity.User;
import com.dent.service.UserService;
import com.dent.web.jwt.JwtUtils;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

import static com.dent.utils.exception.ExceptionHandlingUtil.handleValidationErrors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final ModelMapper mapper = new ModelMapper();
    private final JwtUtils jwtUtils;

    public AuthController(UserService userService, JwtUtils jwtUtils) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/resetPassword")
    public UserExposeDTO resetPassword(@Valid @RequestBody String email, Errors errors) throws NoSuchAlgorithmException {
        handleValidationErrors(errors);
        User user = userService.findUserByEmail(email);

        /*MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] rawOld = md.digest(passwordResetDTO.getOldPassword().getBytes(StandardCharsets.UTF_8));
        final String hashBase64 = Base64.getEncoder().encodeToString(md.digest(rawOld));

        if (!hashBase64.equals(user.getPassword())) {
            throw new InvalidCredentialsDataException(CommonMessages.THE_GIVEN_PASSWORD_IS_INCORRECT);
        } else {
            byte[] newHashedPasswordRaw = md.digest(passwordResetDTO.getNewPassword().getBytes(StandardCharsets.UTF_8));
            final String newHashedPassword = Base64.getEncoder().encodeToString(md.digest(newHashedPasswordRaw));
            user.setPassword(newHashedPassword);
            user.setAccountStatus(AccountStatus.ACTIVE);
            EmailDetails emailDetails = new EmailDetails(CommonMessages.EMS_CREATION_SERVICE_MAILBOX, user.getEmail(), String.format(CommonMessages.PASSWORD_SUCCESSFULLY_CHANGED, user.getFirstName(), user.getLastName()), CommonMessages.SCHOOL_ACCOUNT_PASSWORD_SUCCESSFULLY_CHANGED);
            emailService.sendEmail(emailDetails);
            return mapper.map(userService.updateModel(user), UserExposeDTO.class);
        }*/
        return null;
    }


    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody Credentials credentials, Errors errors) throws NoSuchAlgorithmException {
        handleValidationErrors(errors);
        final User user = userService.findUserByEmail(credentials.getEmail());

        /*MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] raw = md.digest(credentials.getPassword().getBytes(StandardCharsets.UTF_8));
        final String hashBase64 = Base64.getEncoder().encodeToString(md.digest(raw));

        if (!hashBase64.equals(user.getPassword())) {
            throw new InvalidCredentialsDataException(CommonMessages.THE_GIVEN_PASSWORD_IS_INCORRECT);
        }*/
        final String token = jwtUtils.generateToken(user);
        return new LoginResponse(token, user.getEmail());
    }

}
