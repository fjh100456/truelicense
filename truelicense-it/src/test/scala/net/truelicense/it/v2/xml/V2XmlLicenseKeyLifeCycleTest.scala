/*
 * Copyright (C) 2005-2017 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package net.truelicense.it.v2.xml

import net.truelicense.it.core.LicenseKeyLifeCycleTestSuite
import org.junit.runner._
import org.scalatest.junit._

/** @author Christian Schlichtherle */
@RunWith(classOf[JUnitRunner])
class V2XmlLicenseKeyLifeCycleTest
  extends LicenseKeyLifeCycleTestSuite
  with V2XmlTestContext
