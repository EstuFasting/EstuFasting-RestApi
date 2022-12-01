package edu.estu.estufastingrestapi.core.domain.constants;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Role;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@UtilityClass
public class UserRole {

    public final Map<String, Role> MAP;

    static {
        MAP = new LinkedHashMap<>();

        try {
            for (Field idField : Id.class.getDeclaredFields()) {
                int id = idField.getInt(null);
                String name = getByFieldName(idField.getName(), Name.class).map(Object::toString).orElse(null);
                String desc = getByFieldName(idField.getName(), Desc.class).map(Object::toString).orElse(null);
                MAP.put(name, new Role(id, name, desc, null));
            }
        } catch (IllegalAccessException e) {
            log.error(e.getMessage());
        }
    }

    public Role getInstanceByName(String name) {
        Role cache = MAP.get(name);
        return new Role(cache.getId(), cache.getName(), cache.getDescription(), null);
    }

    @UtilityClass
    public class Id {
        public final int USER = 1;
        public final int SUPER_ADMIN = 2;
        public final int SYSTEM_EMPLOYEE = 3;
        public final int CUSTOMER = 4;
    }

    @UtilityClass
    public class Name {
        public final String USER = "ROLE_USER";
        public final String SUPER_ADMIN = "ROLE_SUPER_ADMIN";
        public final String SYSTEM_EMPLOYEE = "ROLE_SYSTEM_EMPLOYEE";
        public final String CUSTOMER = "ROLE_CUSTOMER";
    }

    @UtilityClass
    public class Desc {
        public final String USER = "General user";
        public final String SUPER_ADMIN = "Access to everywhere";
        public final String SYSTEM_EMPLOYEE = "Staff";
        public final String CUSTOMER = "Customer - Client";
    }

    @SneakyThrows
    private String getById(int id, Class<?> clazz) {
        return clazz.getDeclaredFields()[id - 1].get(null).toString();
    }

    @SneakyThrows
    private Optional<Object> getByFieldName(String fieldName, Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getName().equals(fieldName)) return Optional.ofNullable(field.get(null));
        }
        return Optional.empty();
    }

}
