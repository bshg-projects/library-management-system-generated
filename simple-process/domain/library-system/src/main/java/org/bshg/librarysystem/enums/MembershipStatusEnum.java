package org.bshg.librarysystem.enums;
public enum MembershipStatusEnum {
ACTIVE("ACTIVE"),
INACTIVE("INACTIVE"),
EXPIRED("EXPIRED"),
PENDING_APPROVAL("PENDING_APPROVAL"),
CANCELED("CANCELED"),
SUSPENDED("SUSPENDED"),
REVOKED("REVOKED"),
GRACE_PERIOD("GRACE_PERIOD"),
;
private final String value;
MembershipStatusEnum(String value) {
this.value = value;
}
public String value() {
return value;
}
}