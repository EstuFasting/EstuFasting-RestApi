package edu.estu.estufastingrestapi.core.api.config.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.estu.estufastingrestapi.core.model.constants.Validation;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@UtilityClass
public class HttpHelper {

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @SneakyThrows
    public String getBodyString(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        reader.lines().forEach(line -> sb.append(trim(line)));
        inputStream.close();
        reader.close();
        return sb.toString();
    }

    @SneakyThrows
    private String trim(Object object) {
        String json = object instanceof String ? object.toString() : OBJECT_MAPPER.writeValueAsString(object);
        if (json.matches(Validation.Common.RGX_JSON_OBJECT))
            return handleJsonObjectTrim(json);
        if (object instanceof String)
            return String.format("\"%s\"", json.trim());
        return object.toString();
    }

    @SneakyThrows
    private String handleJsonObjectTrim(String line) {
        LinkedHashMap<?, ?> jsonMap = OBJECT_MAPPER.readValue(line, LinkedHashMap.class);
        return jsonMap.entrySet().stream()
                .map(e -> String.format("\"%s\":%s", e.getKey(), trim(e.getValue())))
                .collect(Collectors.joining(",", "{", "}"));
    }

}