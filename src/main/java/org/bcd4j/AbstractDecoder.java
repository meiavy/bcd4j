/*
 * Copyright 2010 Constantin Rack.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bcd4j;

import java.math.BigInteger;

/**
 * Base class for all BCD decoders.
 */
abstract class AbstractDecoder {

    /** Minimal allowed byte value. */
    private static final byte MIN_BYTE_VALUE = 0;

    /** Maximal allowed byte value. */
    private static final byte MAX_BYTE_VALUE = 9;

    /**
     * Decode a BCD byte array as {@link java.lang.String}.
     *
     * @param bytes the bytes
     * @return the decoded value as string
     */
    protected abstract String decodeAsString(final byte[] bytes);

    /**
     * Decode a BCD byte array as {@link java.math.BigInteger}.
     *
     * @param bytes the bytes
     * @return the decoded value as big integer
     */
    public final BigInteger decode(final byte[] bytes) {
        return new BigInteger(decodeAsString(bytes));
    }

    /**
     * Checks if byteValue is valid, i.e. 0 <= byteValue <= 9.
     * 
     * @param byteValue the byte to check.
     */
    protected final void checkByteValue(final byte byteValue) {
        if ((byteValue < MIN_BYTE_VALUE) || (byteValue > MAX_BYTE_VALUE)) {
            throw new IllegalArgumentException("byte value out of range");
        }
    }
    
}