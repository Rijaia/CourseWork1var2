package pro.sky.java.course2.coursework1var2.validate;

import org.apache.commons.lang3.StringUtils;

public class EmployeeValidator {
    public static boolean validate(String firstName, String lastName) {
        return StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName);
    }
}
