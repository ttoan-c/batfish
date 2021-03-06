package org.batfish.representation.palo_alto;

import org.batfish.vendor.StructureType;

public enum PaloAltoStructureType implements StructureType {
  ADDRESS_GROUP("address-group"),
  ADDRESS_LIKE("address-like"),
  // Special abstract structure type to handle the fact that some things that look like references
  // may actually refer to constants like an IP addresses
  ADDRESS_LIKE_OR_NONE("address-like or none"),
  ADDRESS_OBJECT("address object"),
  ADDRESS_OBJECT_OR_NONE("address object or none"),
  APPLICATION("application"),
  APPLICATION_GROUP("application-group"),
  APPLICATION_GROUP_OR_APPLICATION("application-group or application"),
  APPLICATION_GROUP_OR_APPLICATION_OR_NONE("application-group or application or none"),
  APPLICATION_OR_NONE("application or none"),
  APPLICATION_OVERRIDE_RULE("application-override rule"),
  CUSTOM_URL_CATEGORY("custom-url-category"),
  EXTERNAL_LIST("external-list"),
  GLOBAL_PROTECT_APP_CRYPTO_PROFILE("global-protect-app-crypto-profile"),
  IKE_CRYPTO_PROFILE("ike-crypto-profile"),
  IPSEC_CRYPTO_PROFILE("ipsec-crypto-profile"),
  INTERFACE("interface"),
  NAT_RULE("nat rule"),
  REDIST_PROFILE("redist-profile"),
  SECURITY_RULE("security rule"),
  SERVICE("service"),
  SERVICE_GROUP("service-group"),
  SERVICE_OR_SERVICE_GROUP("service or service-group"),
  SERVICE_OR_SERVICE_GROUP_OR_NONE("service or service-group or none"),
  SHARED_GATEWAY("shared-gateway"),
  TEMPLATE("template"),
  VIRTUAL_ROUTER("virtual-router"),
  ZONE("zone");

  private final String _description;

  PaloAltoStructureType(String description) {
    _description = description;
  }

  @Override
  public String getDescription() {
    return _description;
  }
}
