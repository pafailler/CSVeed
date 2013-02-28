package nl.tweeenveertig.csveed.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* Various settings for a BeanReaderInstructionsImpl translating to a CSV cell. By default every field in a BeanReaderInstructionsImpl is expected to be
* a CsvCell, even if not so marked. Use @CsvIgnore to prevent a BeanReaderInstructionsImpl field from being taken into account for
* both serialization and deserialization.
* @author Robert Bor
*/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvCell {

    /**
    * This value will only be used if CsvFile.useHeaders == false. If this value is not set, the index will be
    * automatically determined on the basis of the order of the fields within the class. If this value is set,
    * the column at the index position will be used for mapping to this field.
    * @return the index column to use for the mapping
    */
    int columnIndex() default -1;

    /**
    * By default the column name is inferred from the property name. However, if CsvFile.useHeaders == false, or the
    * naming is not what you want in the BeanInstructions, you can override the column name to map to using this value.
    * @return the column name in the CSV file header to use for mapping
    */
    String columnName() default "";

    /**
    * If required is set, the parse process will generate an error if the value is null after deserialization
    * @return whether the field must be not null
    */
    boolean required() default false;

}
