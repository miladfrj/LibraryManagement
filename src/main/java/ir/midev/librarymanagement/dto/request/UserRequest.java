package ir.midev.librarymanagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {

    @NotNull(message = "{usernam.is.null}")
    @NotBlank(message = "{username.is.blank}")
    private final String username;
    @NotNull(message = "{password.is.null}")
    @NotBlank(message = "password.is.blank")
    private final String password;
}
