package com.arc.core.model.request.system.security;

import com.arc.core.model.request.ArcPageable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserPageRequest extends ArcPageable {

    private Long id;//主键
}
