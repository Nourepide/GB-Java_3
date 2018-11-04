package net.nourepide.learning.database.enity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Users {
    private String id;
    private String name;
    private String password;
}
