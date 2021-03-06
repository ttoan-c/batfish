package org.batfish.representation.arista;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.batfish.datamodel.Prefix;
import org.batfish.datamodel.bgp.RouteDistinguisher;
import org.batfish.datamodel.bgp.community.ExtendedCommunity;

public final class Vrf implements Serializable {
  @Nullable private String _description;
  @Nullable private IsisProcess _isisProcess;
  private final @Nonnull Map<String, LoggingHost> _loggingHosts;
  private @Nullable String _loggingSourceInterface;
  @Nonnull private final String _name;
  @Nonnull private Map<String, OspfProcess> _ospfProcesses;
  @Nullable private RipProcess _ripProcess;
  @Nullable private RouteDistinguisher _routeDistinguisher;
  @Nullable private ExtendedCommunity _routeExportTarget;
  @Nullable private ExtendedCommunity _routeImportTarget;
  private boolean _shutdown;
  @Nonnull private final Map<Prefix, StaticRouteManager> _staticRoutes;
  @Nullable private Integer _vni;

  public Vrf(@Nonnull String name) {
    _name = name;
    _loggingHosts = new HashMap<>(0);
    // Ensure that processes are in insertion order.
    _ospfProcesses = new LinkedHashMap<>(0);
    _staticRoutes = new HashMap<>(0);
  }

  @Nullable
  public String getDescription() {
    return _description;
  }

  @Nullable
  public IsisProcess getIsisProcess() {
    return _isisProcess;
  }

  public @Nonnull Map<String, LoggingHost> getLoggingHosts() {
    return _loggingHosts;
  }

  public @Nullable String getLoggingSourceInterface() {
    return _loggingSourceInterface;
  }

  public void setLoggingSourceInterface(@Nullable String loggingSourceInterface) {
    _loggingSourceInterface = loggingSourceInterface;
  }

  @Nonnull
  public String getName() {
    return _name;
  }

  /** Return OSPF processes defined on this VRF. Guaranteed to be in insertion order */
  @Nonnull
  public Map<String, OspfProcess> getOspfProcesses() {
    return _ospfProcesses;
  }

  @Nullable
  public RipProcess getRipProcess() {
    return _ripProcess;
  }

  /**
   * The route distinguisher to attach to VPN originating from this VRF. Will be {@code null} if it
   * must be auto-derived.
   */
  @Nullable
  public RouteDistinguisher getRouteDistinguisher() {
    return _routeDistinguisher;
  }

  /**
   * The route target value to attach to VPN routes originating from this VRF. Will be {@code null}
   * if it must be auto-derived.
   */
  @Nullable
  public ExtendedCommunity getRouteExportTarget() {
    return _routeExportTarget;
  }

  /**
   * Routes that contain this route target community should be merged into this VRF. Will be {@code
   * null} if it must be auto-derived.
   */
  @Nullable
  public ExtendedCommunity getRouteImportTarget() {
    return _routeImportTarget;
  }

  /** Is this VRF shutdown (not used for routing/forwarding) */
  public boolean isShutdown() {
    return _shutdown;
  }

  /** Layer 3 VNI number associated with this VRF */
  @Nullable
  public Integer getVni() {
    return _vni;
  }

  public @Nonnull Map<Prefix, StaticRouteManager> getStaticRoutes() {
    return _staticRoutes;
  }

  public void setDescription(@Nullable String description) {
    _description = description;
  }

  public void setIsisProcess(@Nullable IsisProcess isisProcess) {
    _isisProcess = isisProcess;
  }

  public void setRipProcess(@Nullable RipProcess ripProcess) {
    _ripProcess = ripProcess;
  }

  public void setRouteDistinguisher(@Nullable RouteDistinguisher routeDistinguisher) {
    _routeDistinguisher = routeDistinguisher;
  }

  public void setRouteExportTarget(@Nullable ExtendedCommunity routeExportTarget) {
    _routeExportTarget = routeExportTarget;
  }

  public void setRouteImportTarget(@Nullable ExtendedCommunity routeImportTarget) {
    _routeImportTarget = routeImportTarget;
  }

  public void setShutdown(boolean shutdown) {
    _shutdown = shutdown;
  }

  public void setVni(@Nullable Integer vni) {
    _vni = vni;
  }
}
