package com.github.MaryHrisanfova.BibliographySystem.utilities;

import com.github.MaryHrisanfova.BibliographySystem.model.User;

/**
 * @author Mariia_Khrisanfova
 */
public class AuthenticationResponse {
    public final String message;
    public User user;

    public AuthenticationResponse() {
        this("AUTHENTICATION_UNSUCCESSFUL");
    }

    public AuthenticationResponse(final String message) {
        this.message = message;
    }

}
