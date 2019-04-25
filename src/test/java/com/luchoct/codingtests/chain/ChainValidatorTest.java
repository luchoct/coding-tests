package com.luchoct.codingtests.chain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ChainValidatorTest {
    @Test
    public void testIsValid() {
        assertTrue(ChainValidator.isValid("4-2;BEGIN-3;3-4;2-END"));
    }
}