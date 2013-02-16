package nl.tweeenveertig.csveed.bean.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* Various settings applying to the entire CSV file and BeanInstructions.
* @author Robert Bor
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CsvFile {

    /**
    * The symbol which escapes a quote character while inside a quoted string. By default a double quote (")
    * @return escape character
    */
    char escape() default '"';

    /**
    * The quote symbol is the sign on both sides of the field value. By default this will be a double quote
    * @return quote symbol for a field
    */
    char quote() default '"';

    /**
    * The separator is the symbol between two fields. By default this will be a semi-colon
    * @return separator between two fields
    */
    char separator() default ';';

    /**
    * The symbols all eligible as end-of-line markers. By default \r and \n are both eol symbols
    * @return all the eligible eol symbols
    */
    char[] endOfLine() default { '\r', '\n' };

    /**
    * States whether the first line will be used as a header line. If this is not the case, the mapping
    * will be done based on column indexes.
    * @return whether to use the first line as a header or not
    */
    boolean useHeader() default true;

    /**
    * The point from where the lines must be read, including the header (if applicable). By default,
    * this value is 0.
    * @return the point from where lines must be converted
    */
    int startRow() default 0;

}