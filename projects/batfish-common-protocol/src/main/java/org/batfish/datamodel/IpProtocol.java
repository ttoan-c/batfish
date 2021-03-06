package org.batfish.datamodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Set;
import org.batfish.common.BatfishException;

/**
 * List of known IP protocols corresponding to their number as assigned by the Internet Assigned
 * Numbers Authority (IANA).
 *
 * <p>See https://www.iana.org/assignments/protocol-numbers/protocol-numbers.xhtml
 */
public enum IpProtocol {
  AHP(51),
  AN(107),
  ANY_0_HOP_PROTOCOL(114),
  ANY_DISTRIBUTED_FILE_SYSTEM(68),
  ANY_HOST_INTERNAL_PROTOCOL(61),
  ANY_LOCAL_NETWORK(63),
  ANY_PRIVATE_ENCRYPTION_SCHEME(99),
  ARGUS(13),
  ARIS(104),
  AX25(93),
  BBN_RCC_MON(10),
  BNA(49),
  BR_SAT_MON(76),
  CBT(7),
  CFTP(62),
  CHAOS(16),
  COMPAQ_PEER(110),
  CPHB(73),
  CPNX(72),
  CRTP(126),
  CRUDP(127),
  DCCP(33),
  DCN_MEAS(19),
  DDP(37),
  DDX(116),
  DGP(86),
  EGP(8),
  EIGRP(88),
  EMCON(14),
  ENCAP(98),
  ESP(50),
  ETHERIP(97),
  FC(133),
  FIRE(125),
  GGP(3),
  GMTP(100),
  GRE(47),
  HIP(139),
  HMP(20),
  HOPOPT(0),
  I_NLSP(52),
  IATP(117),
  ICMP(1),
  IDPR(35),
  IDPR_CMTP(38),
  IDRP(45),
  IFMP(101),
  IGMP(2),
  IGP(9),
  IL(40),
  IPCOMP(108),
  IPCU(71),
  IPINIP(4),
  IPIP(94),
  IPLT(129),
  IPPC(67),
  IPV6(41),
  IPV6_ICMP(58),
  IPX_IN_IP(111),
  IRTP(28),
  ISIS(124),
  ISO_IP(80),
  ISO_TP4(29),
  KRYPTOLAN(65),
  L2TP(115),
  LARP(91),
  LEAF1(25),
  LEAF2(26),
  MANAET(138),
  MERIT_INP(32),
  MFE_NSP(31),
  MHRP(48),
  MICP(95),
  MOBILE(55),
  MOBILITY(135),
  MPLS_IN_IP(137),
  MTP(92),
  MUX(18),
  NARP(54),
  NETBLT(30),
  NSFNET_IGP(85),
  NVPII(11),
  OSPF(89),
  PGM(113),
  PIM(103),
  PIPE(131),
  PNNI(102),
  PRM(21),
  PTP(123),
  PUP(12),
  PVP(75),
  QNX(106),
  RDP(27),
  ROHC(142),
  RSVP(46),
  RSVP_E2E_IGNORE(134),
  RVD(66),
  SAT_EXPAK(64),
  SAT_MON(69),
  SCC_SP(96),
  SCPS(105),
  SCTP(132),
  SDRP(42),
  SECURE_VMTP(82),
  SHIM6(140),
  SKIP(57),
  SM(122),
  SMP(121),
  SNP(109),
  SPRITE_RPC(90),
  SPS(130),
  SRP(119),
  SSCOPMCE(128),
  ST(5),
  STP(118),
  SUN_ND(77),
  SWIPE(53),
  TCF(87),
  TCP(6),
  THREE_PC(34),
  TLSP(56),
  TPPLUSPLUS(39),
  TRUNK1(23),
  TRUNK2(24),
  TTP(84),
  UDP(17),
  UDP_LITE(136),
  /** Is allocated by IANA as Routing Header for IPv6, but this is an IPv4 enum. */
  UNNAMED_43(43),
  /** Is allocated by IANA as Fragment Header for IPv6, but this is an IPv4 enum. */
  UNNAMED_44(44),
  /** Is allocated by IANA as No Next Header for IPv6, but this is an IPv4 enum. */
  UNNAMED_59(59),
  /** Is allocated by IANA as Destination Options for IPv6, but this is an IPv4 enum. */
  UNNAMED_60(60),
  UNNAMED_143(143),
  UNNAMED_144(144),
  UNNAMED_145(145),
  UNNAMED_146(146),
  UNNAMED_147(147),
  UNNAMED_148(148),
  UNNAMED_149(149),
  UNNAMED_150(150),
  UNNAMED_151(151),
  UNNAMED_152(152),
  UNNAMED_153(153),
  UNNAMED_154(154),
  UNNAMED_155(155),
  UNNAMED_156(156),
  UNNAMED_157(157),
  UNNAMED_158(158),
  UNNAMED_159(159),
  UNNAMED_160(160),
  UNNAMED_161(161),
  UNNAMED_162(162),
  UNNAMED_163(163),
  UNNAMED_164(164),
  UNNAMED_165(165),
  UNNAMED_166(166),
  UNNAMED_167(167),
  UNNAMED_168(168),
  UNNAMED_169(169),
  UNNAMED_170(170),
  UNNAMED_171(171),
  UNNAMED_172(172),
  UNNAMED_173(173),
  UNNAMED_174(174),
  UNNAMED_175(175),
  UNNAMED_176(176),
  UNNAMED_177(177),
  UNNAMED_178(178),
  UNNAMED_179(179),
  UNNAMED_180(180),
  UNNAMED_181(181),
  UNNAMED_182(182),
  UNNAMED_183(183),
  UNNAMED_184(184),
  UNNAMED_185(185),
  UNNAMED_186(186),
  UNNAMED_187(187),
  UNNAMED_188(188),
  UNNAMED_189(189),
  UNNAMED_190(190),
  UNNAMED_191(191),
  UNNAMED_192(192),
  UNNAMED_193(193),
  UNNAMED_194(194),
  UNNAMED_195(195),
  UNNAMED_196(196),
  UNNAMED_197(197),
  UNNAMED_198(198),
  UNNAMED_199(199),
  UNNAMED_200(200),
  UNNAMED_201(201),
  UNNAMED_202(202),
  UNNAMED_203(203),
  UNNAMED_204(204),
  UNNAMED_205(205),
  UNNAMED_206(206),
  UNNAMED_207(207),
  UNNAMED_208(208),
  UNNAMED_209(209),
  UNNAMED_210(210),
  UNNAMED_211(211),
  UNNAMED_212(212),
  UNNAMED_213(213),
  UNNAMED_214(214),
  UNNAMED_215(215),
  UNNAMED_216(216),
  UNNAMED_217(217),
  UNNAMED_218(218),
  UNNAMED_219(219),
  UNNAMED_220(220),
  UNNAMED_221(221),
  UNNAMED_222(222),
  UNNAMED_223(223),
  UNNAMED_224(224),
  UNNAMED_225(225),
  UNNAMED_226(226),
  UNNAMED_227(227),
  UNNAMED_228(228),
  UNNAMED_229(229),
  UNNAMED_230(230),
  UNNAMED_231(231),
  UNNAMED_232(232),
  UNNAMED_233(233),
  UNNAMED_234(234),
  UNNAMED_235(235),
  UNNAMED_236(236),
  UNNAMED_237(237),
  UNNAMED_238(238),
  UNNAMED_239(239),
  UNNAMED_240(240),
  UNNAMED_241(241),
  UNNAMED_242(242),
  UNNAMED_243(243),
  UNNAMED_244(244),
  UNNAMED_245(245),
  UNNAMED_246(246),
  UNNAMED_247(247),
  UNNAMED_248(248),
  UNNAMED_249(249),
  UNNAMED_250(250),
  UNNAMED_251(251),
  UNNAMED_252(252),
  UNNAMED_253(253),
  UNNAMED_254(254),
  UNNAMED_255(255),
  UTI(120),
  VINES(83),
  VISA(70),
  VMTP(81),
  VRRP(112),
  WB_EXPAK(79),
  WB_MON(78),
  WESP(141),
  WSN(74),
  XNET(15),
  XNS_IDP(22),
  XTP(36);

  public static final Set<IpProtocol> IP_PROTOCOLS_WITH_PORTS =
      ImmutableSet.of(TCP, UDP, DCCP, SCTP);

  /** Set of IP protocols for which we will establish sessions. TODO may be vendor-specific. */
  public static final Set<IpProtocol> IP_PROTOCOLS_WITH_SESSIONS = ImmutableSet.of(TCP, UDP, ICMP);

  private static final Map<Integer, IpProtocol> NUMBER_TO_PROTOCOL_MAP = buildNumberToProtocolMap();

  private static Map<Integer, IpProtocol> buildNumberToProtocolMap() {
    ImmutableMap.Builder<Integer, IpProtocol> map = ImmutableMap.builder();
    for (IpProtocol protocol : values()) {
      map.put(protocol._number, protocol);
    }
    return map.build();
  }

  public static IpProtocol fromNumber(int number) {
    IpProtocol ret = NUMBER_TO_PROTOCOL_MAP.get(number);
    if (ret == null) {
      throw new BatfishException("missing enumeration for protocol number: " + number);
    }
    return ret;
  }

  @JsonCreator
  public static IpProtocol fromString(String str) {
    char firstChar = str.charAt(0);
    if (firstChar >= '0' && firstChar <= '9') {
      int number = Integer.parseInt(str);
      return fromNumber(number);
    } else {
      return valueOf(str.toUpperCase());
    }
  }

  private int _number;

  IpProtocol(int number) {
    _number = number;
  }

  public int number() {
    return _number;
  }
}
