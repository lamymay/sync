package com.arc.core.model.request.app.contact;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 叶超
 * @since 2020/2/29 11:51
 */
@Getter
@Setter
@ToString
public class CompareAndSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer save = 0;
    private Integer delete = 0;
    private Integer update = 0;

    public CompareAndSaveDTO() {
    }

    public CompareAndSaveDTO(Integer save, Integer delete, Integer update) {
        this.save = save;
        this.delete = delete;
        this.update = update;
    }
}
