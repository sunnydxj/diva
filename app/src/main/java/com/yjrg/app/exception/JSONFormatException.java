package com.yjrg.app.exception;

/**
 * JSON格式错误
 *
 * @author valuesFeng
 */
public class JSONFormatException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public JSONFormatException() {
        super();
    }

    public JSONFormatException(String message) {
        super(message);
    }

    public JSONFormatException(Throwable e) {
        super(e);
    }
}
