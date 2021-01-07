package org.batfish.datamodel.route.nh;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.MoreObjects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.batfish.datamodel.Ip;

/**
 * Route next hop with a concrete {@link Ip} address. Note that this class will reject invalid
 * values such as {@link Ip#ZERO}, {@link Ip#AUTO}.
 */
public final class NextHopIp implements NextHop {

  @Nonnull
  public static NextHopIp of(Ip ip) {
    return new NextHopIp(ip);
  }

  @Nonnull
  public Ip getIp() {
    return _ip;
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof NextHopIp)) {
      return false;
    }
    NextHopIp nextHopIp = (NextHopIp) o;
    return _ip.equals(nextHopIp._ip);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(NextHop.class).add("ip", _ip).toString();
  }

  @Override
  public int hashCode() {
    return _ip.hashCode();
  }

  @Override
  public <T> T accept(NextHopVisitor<T> visitor) {
    return visitor.visitNextHopIp(this);
  }

  @Nonnull private final Ip _ip;

  private NextHopIp(Ip ip) {
    // TODO: prohibit Ip.ZERO
    checkArgument(
        !ip.equals(Ip.AUTO) && !ip.equals(Ip.MAX),
        "NextHopIp must be a valid concrete IP address. Received %s",
        ip);
    _ip = ip;
  }
}
