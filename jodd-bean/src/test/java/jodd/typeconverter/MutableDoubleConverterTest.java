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

import jodd.mutable.MutableDouble;
import jodd.typeconverter.impl.MutableDoubleConverter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MutableDoubleConverterTest {

	@Test
	void testConversion() {
		MutableDoubleConverter mutableDoubleConverter = (MutableDoubleConverter) TypeConverterManager.lookup(MutableDouble.class);

		assertNull(mutableDoubleConverter.convert(null));

		assertEquals(new MutableDouble(1.73), mutableDoubleConverter.convert(new MutableDouble(1.73)));
		assertEquals(new MutableDouble(1), mutableDoubleConverter.convert(Integer.valueOf(1)));
		assertEquals(new MutableDouble(1.73), mutableDoubleConverter.convert(Double.valueOf(1.73D)));
		assertEquals(new MutableDouble(1.73), mutableDoubleConverter.convert("1.73"));
		assertEquals(new MutableDouble(1.73), mutableDoubleConverter.convert(" 1.73 "));
		assertEquals(new MutableDouble(1.73), mutableDoubleConverter.convert(new BigDecimal("1.73")));

		try {
			mutableDoubleConverter.convert("aaaa");
			fail("error");
		} catch (TypeConversionException ignore) {
		}
	}
}

