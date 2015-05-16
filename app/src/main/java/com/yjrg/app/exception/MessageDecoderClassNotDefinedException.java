package com.yjrg.app.exception;

/**
 * 消息解码Class未定义
 *
 * @author valuesFeng
 */
public class MessageDecoderClassNotDefinedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MessageDecoderClassNotDefinedException() {
        super();
    }

    public MessageDecoderClassNotDefinedException(String message) {
        super(message);
    }
}
