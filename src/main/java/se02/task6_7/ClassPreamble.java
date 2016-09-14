package se02.task6_7;

import java.lang.annotation.Documented;

@Documented
public @interface ClassPreamble {
    String author();

    String date();
}
