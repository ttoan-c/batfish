package org.batfish.minesweeper.communities;

import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.batfish.datamodel.Configuration;
import org.batfish.datamodel.ConfigurationFormat;
import org.batfish.datamodel.NetworkFactory;
import org.batfish.datamodel.TraceElement;
import org.batfish.datamodel.bgp.community.Community;
import org.batfish.datamodel.bgp.community.StandardCommunity;
import org.batfish.datamodel.routing_policy.communities.ColonSeparatedRendering;
import org.batfish.datamodel.routing_policy.communities.CommunityMatchRegex;
import org.batfish.datamodel.routing_policy.communities.CommunitySet;
import org.batfish.datamodel.routing_policy.communities.HasCommunity;
import org.batfish.datamodel.routing_policy.communities.InputCommunities;
import org.batfish.datamodel.routing_policy.communities.LiteralCommunitySet;
import org.batfish.datamodel.routing_policy.communities.MatchCommunities;
import org.batfish.datamodel.routing_policy.communities.SetCommunities;
import org.batfish.datamodel.routing_policy.expr.ExplicitAs;
import org.batfish.datamodel.routing_policy.expr.LiteralAsList;
import org.batfish.datamodel.routing_policy.statement.BufferedStatement;
import org.batfish.datamodel.routing_policy.statement.ExcludeAsPath;
import org.batfish.datamodel.routing_policy.statement.If;
import org.batfish.datamodel.routing_policy.statement.TraceableStatement;
import org.batfish.minesweeper.CommunityVar;
import org.junit.Before;
import org.junit.Test;

/** Tests for {@link RoutePolicyStatementVarCollector}. */
public class RoutePolicyStatementVarCollectorTest {
  private static final String HOSTNAME = "hostname";
  private Configuration _baseConfig;
  private RoutePolicyStatementVarCollector _varCollector;

  private static final Community COMM1 = StandardCommunity.parse("20:30");
  private static final Community COMM2 = StandardCommunity.parse("21:30");

  @Before
  public void setup() {
    NetworkFactory nf = new NetworkFactory();
    Configuration.Builder cb =
        nf.configurationBuilder()
            .setHostname(HOSTNAME)
            .setConfigurationFormat(ConfigurationFormat.CISCO_IOS);
    _baseConfig = cb.build();
    nf.vrfBuilder().setOwner(_baseConfig).setName(Configuration.DEFAULT_VRF_NAME).build();

    _varCollector = new RoutePolicyStatementVarCollector();
  }

  @Test
  public void testVisitBufferedStatement() {
    BufferedStatement bs =
        new BufferedStatement(new SetCommunities(new LiteralCommunitySet(CommunitySet.of(COMM1))));

    Set<CommunityVar> result = _varCollector.visitBufferedStatement(bs, _baseConfig);

    assertEquals(ImmutableSet.of(CommunityVar.from(COMM1)), result);
  }

  @Test
  public void testVisitIf() {
    If ifStmt =
        new If(
            new MatchCommunities(
                InputCommunities.instance(),
                new HasCommunity(
                    new CommunityMatchRegex(ColonSeparatedRendering.instance(), "^20:"))),
            ImmutableList.of(new SetCommunities(new LiteralCommunitySet(CommunitySet.of(COMM1)))),
            ImmutableList.of(new SetCommunities(new LiteralCommunitySet(CommunitySet.of(COMM2)))));

    Set<CommunityVar> result = _varCollector.visitIf(ifStmt, _baseConfig);

    Set<CommunityVar> expected =
        ImmutableSet.of(
            CommunityVar.from("^20:"), CommunityVar.from(COMM1), CommunityVar.from(COMM2));

    assertEquals(expected, result);
  }

  @Test
  public void testVisitSetCommunities() {
    SetCommunities sc = new SetCommunities(new LiteralCommunitySet(CommunitySet.of(COMM1)));

    Set<CommunityVar> result = _varCollector.visitSetCommunities(sc, _baseConfig);

    assertEquals(ImmutableSet.of(CommunityVar.from(COMM1)), result);
  }

  @Test
  public void testVisitTraceableStatement() {
    TraceableStatement traceableStatement =
        new TraceableStatement(
            TraceElement.of("statement"),
            ImmutableList.of(new SetCommunities(new LiteralCommunitySet(CommunitySet.of(COMM1)))));

    assertEquals(
        _varCollector.visitTraceableStatement(traceableStatement, _baseConfig),
        ImmutableSet.of(CommunityVar.from(COMM1)));
  }

  @Test
  public void testVisitExcludeAsPath() {
    ExcludeAsPath excludeAsPath =
        new ExcludeAsPath(new LiteralAsList(ImmutableList.of(new ExplicitAs(1L))));

    assertEquals(ImmutableSet.of(), _varCollector.visitExcludeAsPath(excludeAsPath, _baseConfig));
  }
}
