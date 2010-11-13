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

/**
 * The Class PackedBcdDecoder.
 */
class PackedBinaryCodedDecimalDecoder
    extends AbstractBinaryCodedDecimalDecoder {

    /** Number of bits to shift left to produce packed BCD format. */
    static final int BIT_SHIFT = 4;

    /** Bit mask to get only the lowest four bits. */
    static final int BIT_MASK = 0x0F;

    /* (non-Javadoc)
     * @see org.bcd4j.AbstractBcdDecoder#decodeAsString(byte[])
     */
    @Override
    protected final String decodeAsString(final byte[] bytes) {
        final char[] chars = new char[bytes.length << 1];
        decodeBytes(bytes, chars);
        return String.valueOf(chars);
    }

    /**
     *
     * @param bytes
     */
    private void decodeBytes(final byte[] bytes, final char[] chars) {
        int i = 0;
        for (byte value : bytes) {
            chars[i++] = decodeByte((byte) ((value >> BIT_SHIFT) & BIT_MASK));
            chars[i++] = decodeByte((byte) (value & BIT_MASK));
        }
    }

    /**
     * 
     * @param byteValue
     */
    private char decodeByte(byte byteValue) {
        checkByteValue(byteValue);
        return (char) ('0' + byteValue);
    }

}
