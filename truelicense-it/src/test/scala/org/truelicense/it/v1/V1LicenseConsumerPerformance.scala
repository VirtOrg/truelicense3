/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package org.truelicense.it.v1

import org.truelicense.it.core.LicenseConsumerPerformance

/** @author Christian Schlichtherle */
object V1LicenseConsumerPerformance
extends LicenseConsumerPerformance with V1TestContext {
  def main(args: Array[String]) = call ()
}
