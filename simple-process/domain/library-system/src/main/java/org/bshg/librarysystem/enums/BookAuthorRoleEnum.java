package org.bshg.librarysystem.enums;
public enum BookAuthorRoleEnum {
MAIN_AUTHOR("MAIN_AUTHOR"),
CO_AUTHOR("CO_AUTHOR"),
EDITOR("EDITOR"),
CONTRIBUTOR("CONTRIBUTOR"),
GHOST_WRITER("GHOST_WRITER"),
ILLUSTRATOR("ILLUSTRATOR"),
TRANSLATOR("TRANSLATOR"),
REVIEWER("REVIEWER"),
ADVISOR("ADVISOR"),
;
private final String value;
BookAuthorRoleEnum(String value) {
this.value = value;
}
public String value() {
return value;
}
}