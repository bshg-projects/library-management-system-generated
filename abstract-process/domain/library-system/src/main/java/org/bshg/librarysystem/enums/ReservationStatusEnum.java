package org.bshg.librarysystem.enums;
public enum ReservationStatusEnum {
PENDING("PENDING"),
APPROVED("APPROVED"),
CANCELED("CANCELED"),
COMPLETED("COMPLETED"),
;
private final String value;
ReservationStatusEnum(String value) {
this.value = value;
}
public String value() {
return value;
}
}