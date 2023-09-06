package com.arc.core.config.annotations;

import lombok.Data;


@Data
public class NoteDescribe {

    String value;
    String name;
    int priority;


    public NoteDescribe() {

    }

    public NoteDescribe(Note noteAnnotation) {
        if (noteAnnotation != null) {
            this.value = noteAnnotation.value();
            this.name = noteAnnotation.name();
            this.priority = noteAnnotation.priority();
        }
    }

    public NoteDescribe(String value, String name, int priority) {
        this.value = value;
        this.name = name;
        this.priority = priority;
    }
}
