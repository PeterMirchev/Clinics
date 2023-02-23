package com.dent.model.dto.expose;

import com.dent.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardExposeDTO {
    private long id;
    private Set<User> users = new HashSet<>();
    private String wardType;
}
