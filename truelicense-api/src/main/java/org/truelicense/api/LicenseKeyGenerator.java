/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package org.truelicense.api;

import org.truelicense.api.io.Sink;

/**
 * Generates a license key and writes it to a given sink or returns a duplicate
 * of its encoded license bean.
 * License key generators are the product of a call to
 * {@link VendorLicenseManager#generator(License)}.
 * License key generators are stateful and so they are generally <em>not</em>
 * thread-safe.
 * <p>
 * When the license key gets generated, a protective copy of the configured
 * license bean is made which is subsequently
 * {@linkplain LicenseInitialization#initialize initialized} and
 * {@linkplain LicenseValidation#validate validated}.
 *
 * @author Christian Schlichtherle
 */
public interface LicenseKeyGenerator {

    /**
     * Saves the generated license key to the given sink.
     * <p>
     * Calling this operation performs an initial
     * {@linkplain LicenseManagementAuthorization#clearSave authorization check}.
     *
     * @param sink the sink for writing the generated license key to.
     * @return {@code this}
     */
    LicenseKeyGenerator save(Sink sink) throws LicenseManagementException;

    /**
     * Returns a duplicate of the license bean which is encoded in the generated
     * license key.
     */
    License license() throws LicenseManagementException;
}

/*
Life cycle: Generate, save, install, load, verify, uninstall.
 */