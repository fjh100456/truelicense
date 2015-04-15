/*
 * Copyright (C) 2005-2015 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */

package org.truelicense.api.auth;

import org.truelicense.api.codec.Codec;

import javax.annotation.concurrent.Immutable;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 * A controller for storing authenticated objects (artifacts).
 * This interface is used by {@linkplain Authentication authentications} to
 * {@linkplain Authentication#sign sign} and
 * {@linkplain Authentication#verify verify} artifacts.
 *
 * @author Christian Schlichtherle
 */
@Immutable
public interface Repository {

    /**
     * Encodes and signs the given {@code artifact}
     * and returns an artifactory for decoding it.
     * As a side effect, the state of this repository is modified so that a
     * subsequent {@linkplain #verify verification} can succeed.
     *
     * @param  codec
     *         the codec for encoding the artifact.
     * @param  engine
     *         the signature engine.
     * @param  key
     *         the private key.
     * @param  artifact
     *         the artifact to sign.
     */
    Artifactory sign(
            Codec codec,
            Signature engine,
            PrivateKey key,
            Object artifact)
    throws Exception;

    /**
     * Verifies the signature of the encoded artifact
     * and returns an artifactory for decoding it.
     * The state of this repository is not modified by this method.
     *
     * @param  codec
     *         the codec for decoding the artifact.
     * @param  engine
     *         the signature engine.
     * @param  key
     *         the public key.
     * @throws RepositoryIntegrityException if the integrity of the repository
     *         with its encoded artifact has been compromised.
     */
    Artifactory verify(
            Codec codec,
            Signature engine,
            PublicKey key)
    throws Exception;
}