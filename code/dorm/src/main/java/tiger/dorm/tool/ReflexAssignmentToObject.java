package tiger.dorm.tool;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.stereotype.Component;

import tiger.dorm.entity.Dorm;

@Component
public class ReflexAssignmentToObject {
    private static boolean success = false; 
	public <T> T assignment(T object, String field, String value) {
		success = false;
		Class c = object.getClass();
		try {
			Field f = c.getDeclaredField(field);
			Class type = f.getType();
			Method method = c.getDeclaredMethod("set" + field.substring(0, 1).toUpperCase() + field.substring(1), type);
			if (type != String.class) {
				if (type == int.class) {
					int parameter = Integer.valueOf(value);	
					method.invoke(object, parameter);
				} else if (type == double.class) {
					double parameter = Double.valueOf(value);
					method.invoke(object, parameter);
				}
			} else {
				String parameter = "";
					parameter = value;

				method.invoke(object, parameter);
				success = true;
			}
		} catch (NoSuchFieldException e) {
			return object; 
		}
		catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {

			e.printStackTrace();
		}
		return object;
	}
     public boolean isSuccess() {
    	 return success;
     }
}
