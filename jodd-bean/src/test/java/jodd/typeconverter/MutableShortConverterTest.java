// Copyright (c) 2003-present, Jodd Team (http://jodd.org)
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// 1. Redistributions of source code must retain the above copyright notice,
// this list of conditions and the following disclaimer.
//
// 2. Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.

package jodd.typeconverter;

import jodd.mutable.MutableShort;
import jodd.typeconverter.impl.MutableShortConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MutableShortConverterTest {

	@Test
	void testConversion() {
		MutableShortConverter mutableShortConverter = (MutableShortConverter) TypeConverterManager.lookup(MutableShort.class);

		assertNull(mutableShortConverter.convert(null));

		assertEquals(new MutableShort((short) 1), mutableShortConverter.convert(new MutableShort(1)));
		assertEquals(new MutableShort((short) 1), mutableShortConverter.convert(Integer.valueOf(1)));
		assertEquals(new MutableShort((short) 1), mutableShortConverter.convert(Short.valueOf((short) 1)));
		assertEquals(new MutableShort((short) 1), mutableShortConverter.convert(Double.valueOf(1.0D)));
		assertEquals(new MutableShort((short) 1), mutableShortConverter.convert("1"));
		assertEquals(new MutableShort((short) 1), mutableShortConverter.convert(" 1 "));

		try {
			mutableShortConverter.convert("a");
			fail("error");
		} catch (TypeConversionException ignore) {
		}
	}
}

