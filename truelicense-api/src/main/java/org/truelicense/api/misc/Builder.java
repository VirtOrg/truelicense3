/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package org.truelicense.api.misc;

/**
 * A builder for some product.
 * Builders are generally <em>not</em> thread-safe.
 *
 * @param  <Product> the type of the product.
 * @author Christian Schlichtherle
 */
public interface Builder<Product> {

    /** Builds and returns a new product. */
    Product build();
}
