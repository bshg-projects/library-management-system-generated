package org.bshg.librarysystem.entity.enums;

public enum AssignmentRoleTypeEnum {
    SUPERVISOR("SUPERVISOR"),
    MANAGER("MANAGER"),
    TEAM_LEAD("TEAM_LEAD"),
    ;
    private final String value;

    AssignmentRoleTypeEnum(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}