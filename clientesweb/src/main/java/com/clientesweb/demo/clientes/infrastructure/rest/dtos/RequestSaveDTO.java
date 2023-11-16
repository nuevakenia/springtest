package com.clientesweb.demo.clientes.infrastructure.rest.dtos;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import static com.clientesweb.demo.utils.Utils_Constants.*;

@Data
public class RequestSaveDTO {
    @NotNull(message = "nombre" + ERROR_MSG_INCOMPLETO)
    @Pattern(regexp = ERROR_LETRAS_REGEX, message = ERROR_MSG_SOLO_LETRAS)
    private String nombre;
    @NotNull(message = "apellido" + ERROR_MSG_INCOMPLETO)
    @Pattern(regexp = ERROR_LETRAS_REGEX, message = ERROR_MSG_SOLO_LETRAS)
    private String apellido;
    @NotNull(message = "email" + ERROR_MSG_INCOMPLETO)
    @Pattern(regexp = ERROR_EMAIL_REGEX, message = ERROR_EMAIL_REGEX)
    private String email;
}
