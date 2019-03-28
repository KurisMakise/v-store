package store.common.base;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @creator violet
 * @createTime 2019/3/8
 * @description
 */
public interface BaseVO {
    /**
     * @param obj 加载相同名称的属性值
     */
    default void loadFields(Object obj) {
        Class objClazz = obj.getClass();

        Field[] fromFields = objClazz.getDeclaredFields();
        Field[] toFields = this.getClass().getDeclaredFields();


        StringBuffer fieldNamesBuffer = new StringBuffer();
        for (Field field : fromFields) {
            fieldNamesBuffer.append(field.getName()).append(", ");
        }

        for (Field toField : toFields) {
            String fieldName = toField.getName();
            if (fieldNamesBuffer.indexOf(fieldName + ", ") == -1) {
                continue;
            }

            toField.setAccessible(true);
            try {
                Field fromField = objClazz.getDeclaredField(fieldName);
                fromField.setAccessible(true);
                Object fromFieldValue = fromField.get(obj);

                toField.set(this, fromFieldValue);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
