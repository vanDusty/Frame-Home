package com.van.dusty.enums;

import com.van.dusty.common.utils.StringUtils;

/**
 * 项目枚举
 */
public enum ProjectNameEnum {
    DUSTY_BLOG("dusty_blog","博客",1),

    ;
    private String projectName;
    private String name;
    private int projectId;

    ProjectNameEnum(String projectName, String name, int projectId) {
        this.projectName = projectName;
        this.name = name;
        this.projectId = projectId;
    }

    public static ProjectNameEnum getEnumByProjectName(String projectName){
        if(StringUtils.isBlank(projectName)){
            return null;
        }
        for (ProjectNameEnum projectNameEnum : values()) {
            if(projectNameEnum.projectName.equals(projectName)){
                return projectNameEnum;
            }
        }
        return null;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
