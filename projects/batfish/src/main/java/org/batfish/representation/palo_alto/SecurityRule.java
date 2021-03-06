package org.batfish.representation.palo_alto;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.batfish.datamodel.LineAction;

/** PAN datamodel component containing security rule configuration */
@ParametersAreNonnullByDefault
public final class SecurityRule implements Serializable {

  public enum RuleType {
    INTERZONE,
    INTRAZONE,
    UNIVERSAL
  }

  // Name of the rule
  @Nonnull private final String _name;
  // Action of the rule
  @Nonnull private LineAction _action;

  @Nonnull private Set<CustomUrlCategoryReference> _category;

  // Owning Vsys of this rule
  @Nonnull private final Vsys _vsys;

  // Description of the rule
  @Nullable private String _description;

  private boolean _disabled;

  // Zones
  @Nonnull private final SortedSet<String> _from;
  @Nonnull private final SortedSet<String> _to;

  // IPs
  @Nonnull private Set<RuleEndpoint> _source;
  @Nonnull private Set<RuleEndpoint> _destination;
  private boolean _negateSource;
  private boolean _negateDestination;

  // Services
  @Nonnull private final SortedSet<ServiceOrServiceGroupReference> _service;

  // Applications
  @Nonnull private final SortedSet<ApplicationOrApplicationGroupReference> _applications;

  // Rule type
  @Nullable private RuleType _ruleType;

  @Nonnull private final Set<String> _tags;

  public SecurityRule(String name, Vsys vsys) {
    _action = LineAction.DENY;
    _applications = new TreeSet<>();
    _category = ImmutableSet.of();
    _destination = ImmutableSet.of();
    _negateDestination = false;
    _disabled = false;
    _from = new TreeSet<>();
    _service = new TreeSet<>();
    _source = ImmutableSet.of();
    _negateSource = false;
    _to = new TreeSet<>();
    _tags = new HashSet<>(1);
    _name = name;
    _vsys = vsys;
  }

  @Nonnull
  public String getName() {
    return _name;
  }

  @Nonnull
  public LineAction getAction() {
    return _action;
  }

  public void addApplication(String application) {
    _applications.add(new ApplicationOrApplicationGroupReference(application));
  }

  public void addCategory(String category) {
    CustomUrlCategoryReference ref = new CustomUrlCategoryReference(category);
    if (_category.contains(ref)) {
      return;
    }
    _category =
        ImmutableSet.<CustomUrlCategoryReference>builderWithExpectedSize(_category.size() + 1)
            .addAll(_category)
            .add(ref)
            .build();
  }

  @Nonnull
  public SortedSet<ApplicationOrApplicationGroupReference> getApplications() {
    return ImmutableSortedSet.copyOf(_applications);
  }

  @Nonnull
  public Set<CustomUrlCategoryReference> getCategory() {
    return _category;
  }

  @Nullable
  public String getDescription() {
    return _description;
  }

  public void addDestination(RuleEndpoint endpoint) {
    if (_destination.contains(endpoint)) {
      return;
    }
    _destination =
        ImmutableSet.<RuleEndpoint>builderWithExpectedSize(_destination.size() + 1)
            .addAll(_destination)
            .add(endpoint)
            .build();
  }

  @Nonnull
  public Set<RuleEndpoint> getDestination() {
    return _destination;
  }

  public boolean getDisabled() {
    return _disabled;
  }

  @Nonnull
  public SortedSet<String> getFrom() {
    return _from;
  }

  public boolean getNegateDestination() {
    return _negateDestination;
  }

  public void setNegateDestination(boolean negateDestination) {
    _negateDestination = negateDestination;
  }

  public boolean getNegateSource() {
    return _negateSource;
  }

  public void setNegateSource(boolean negateSource) {
    _negateSource = negateSource;
  }

  @Nonnull
  public SortedSet<ServiceOrServiceGroupReference> getService() {
    return _service;
  }

  public void addSource(RuleEndpoint endpoint) {
    if (_source.contains(endpoint)) {
      return;
    }
    _source =
        ImmutableSet.<RuleEndpoint>builderWithExpectedSize(_source.size() + 1)
            .addAll(_source)
            .add(endpoint)
            .build();
  }

  @Nonnull
  public Set<RuleEndpoint> getSource() {
    return _source;
  }

  @Nonnull
  public SortedSet<String> getTo() {
    return _to;
  }

  @Nonnull
  public Set<String> getTags() {
    return _tags;
  }

  @Nonnull
  public Vsys getVsys() {
    return _vsys;
  }

  @Nullable
  public RuleType getRuleType() {
    return _ruleType;
  }

  public void setAction(LineAction action) {
    _action = action;
  }

  public void setDescription(String description) {
    _description = description;
  }

  public void setDisabled(boolean disabled) {
    _disabled = disabled;
  }

  public void setRuleType(@Nullable RuleType ruleType) {
    _ruleType = ruleType;
  }
}
