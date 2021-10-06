parser grammar A10Parser;

import
  A10_common,
  A10_interface,
  A10_ip_nat,
  A10_ip_route,
  A10_lacp_trunk,
  A10_rba,
  A10_trunk,
  A10_vlan;

options {
   superClass = 'org.batfish.grammar.BatfishParser';
   tokenVocab = A10Lexer;
}

a10_configuration: NEWLINE? statement+ EOF;

statement
:
   s_hostname
   | s_interface
   | s_ip
   | s_lacp_trunk
   | s_no
   | s_rba
   | s_trunk
   | s_vlan
;

s_ip: IP si;

si: si_nat | si_route;

s_no: NO sn_ip;

sn_ip: IP sni;

sni: sni_route;

s_hostname: HOSTNAME hostname NEWLINE;