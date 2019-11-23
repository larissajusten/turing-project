package br.com.cwi.crescer.api.security;

public enum ClaimTypes {

    MATRICULA("matricula"),
    NAMEIDENTIFIER("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/nameidentifier"),
    NAME("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/name"),
    EMAILADDRESS("http://schemas.xmlsoap.org/ws/2005/05/identity/claims/emailaddress");

    private final String text;

    ClaimTypes(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
