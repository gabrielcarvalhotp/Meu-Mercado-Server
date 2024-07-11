package com.gabrielcarvalhotp.api.meumercado.helpers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class URIHelpers {
    public static URI servletUri(String path, Object... uriVariableValues) {
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path(path)
                .buildAndExpand(uriVariableValues)
                .toUri();
    }
}
