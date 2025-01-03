package com.filipedias.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filipedias.model.Email;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;

@Log4j2
public class MagicLinkValidation {

    public static Email bodyValidation (InputStream data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Email email = mapper.readValue(data, Email.class);

        if (email.getEmail().isEmpty())
            throw new IllegalArgumentException("O campo 'email' está vazio ou ausente.");
        if (email.getEmail().length() <= 4)
            throw new IllegalArgumentException("O campo 'email' é muito curto para ser válido.");

        return email;
    }

}
