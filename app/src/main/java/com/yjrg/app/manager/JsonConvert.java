package com.yjrg.app.manager;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * Created by gavin on 14-6-7.
 */
public class JsonConvert implements Converter {

    private String encoding;

    public JsonConvert() {
        this("UTF-8");
    }

    public JsonConvert(String encoding) {
        this.encoding = encoding;
    }

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {
        Object result = null;

        String charset = "UTF-8";

        if (body.mimeType() != null) {
            charset = MimeUtil.parseCharset(body.mimeType());
        }

        InputStreamReader isr = null;

        try {
            isr = new InputStreamReader(body.in(), charset);
            StringBuilder sb = new StringBuilder();

            int c = 0;

            while ((c = isr.read()) != -1) {
                sb.append((char) c);
            }

            result = JSON.parseObject(sb.toString(), type);

            return result;
        } catch (IOException e) {
            throw new ConversionException(e);
        } catch (Exception e) {
            throw new ConversionException(e);
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    @Override
    public TypedOutput toBody(Object object) {

        try {
            return new JsonTypedOutput(JSON.toJSONString(object).getBytes(encoding), encoding);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }

    }

    private static class JsonTypedOutput implements TypedOutput {
        private final byte[] jsonBytes;
        private final String mimeType;

        JsonTypedOutput(byte[] jsonBytes, String encode) {
            this.jsonBytes = jsonBytes;
            this.mimeType = "application/json";
        }

        @Override
        public String fileName() {
            return null;
        }

        @Override
        public String mimeType() {
            return mimeType;
        }

        @Override
        public long length() {
            return jsonBytes.length;
        }

        @Override
        public void writeTo(OutputStream out) throws IOException {
            out.write(jsonBytes);
        }
    }
}
