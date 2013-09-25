package storage.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import storage.OperationType;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Storage {
	/* ≤Ÿ◊˜¿‡–Õ */
	public OperationType type();
	
	/* ¥Ê¥¢≈‰÷√ */
	public String configKey();
}
