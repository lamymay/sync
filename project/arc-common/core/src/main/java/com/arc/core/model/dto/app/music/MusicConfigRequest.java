package com.arc.core.model.dto.app.music;

import lombok.Data;

/**
 * 配置文件
 *
 * @author may
 * @since 2021.12.09 11:20 下午
 */
@Data
public class MusicConfigRequest {

    /**
     * 扫描根目录
     */
    private String scanDirectory;

    /**
     * 删除时候是否备份
     */
    private Boolean backup;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件大小
     */
    private Long length;

    public MusicConfigRequest() {

    }

    public MusicConfigRequest(String scanDirectory) {
        this.scanDirectory = scanDirectory;
    }
}
