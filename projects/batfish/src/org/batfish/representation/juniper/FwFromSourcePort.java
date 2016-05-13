package org.batfish.representation.juniper;

import org.batfish.datamodel.SubRange;
import org.batfish.main.Warnings;
import org.batfish.representation.Configuration;
import org.batfish.representation.IpAccessListLine;

public final class FwFromSourcePort extends FwFrom {

   /**
       *
       */
   private static final long serialVersionUID = 1L;

   private final SubRange _portRange;

   public FwFromSourcePort(int port) {
      _portRange = new SubRange(port, port);
   }

   public FwFromSourcePort(SubRange subrange) {
      _portRange = subrange;
   }

   @Override
   public void applyTo(IpAccessListLine line, JuniperConfiguration jc,
         Warnings w, Configuration c) {
      line.getSrcPortRanges().add(_portRange);
   }

   public SubRange getPortRange() {
      return _portRange;
   }

}
