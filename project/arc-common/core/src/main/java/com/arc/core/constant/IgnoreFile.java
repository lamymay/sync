package com.arc.core.constant;

/**
 * @author may
 * @since 2021.12.19 11:50 上午
 */
public interface IgnoreFile {

    /**
     * mac上隐藏文件
     */
    String desktopServicesStore = ".DS_Store";

    /**
     * WIN上隐藏文件
     */
    String desktopIni = "desktop.ini";

}

//删除项目中的所有.DS_Store。这会跳过不在项目中的 .DS_Store
//1.find . -name .DS_Store -print0 | xargs -0 git rm -f --ignore-unmatch
//将 .DS_Store 加入到 .gitignore
//2.echo .DS_Store >> ~/.gitignore
//更新项目
//3.git add --all
//4.git commit -m '.DS_Store banished!'