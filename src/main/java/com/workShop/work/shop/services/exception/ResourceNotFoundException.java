package com.workShop.work.shop.services.exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource Not Found. Id: " + id);
    }
}
