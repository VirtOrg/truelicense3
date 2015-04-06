/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package org.truelicense.swing;

import javax.annotation.concurrent.Immutable;
import org.truelicense.core.License;
import org.truelicense.core.LicenseConsumerManager;
import org.truelicense.core.LicenseManagementException;
import org.truelicense.core.io.Source;
import org.truelicense.swing.util.Enabler;

/**
 * A decorating license consumer manager which enables a component after it has
 * successfully called {@link #install} or {@link #uninstall} on the delegate
 * manager.
 * If the operation fails, the component's state remains unchanged.
 *
 * @author Christian Schlichtherle
 */
@Immutable
final class EnablingLicenseConsumerManager
extends UpdatingLicenseConsumerManager {

    private static final long serialVersionUID = 0L;

    EnablingLicenseConsumerManager(
            Enabler enabler,
            LicenseConsumerManager manager) {
        super(manager, enabler);
    }

    @Override
    public void install(final Source source) throws LicenseManagementException {
        manager.install(source);
        enable();
    }

    @Override
    public void uninstall() throws LicenseManagementException {
        manager.uninstall();
        enable();
    }
}