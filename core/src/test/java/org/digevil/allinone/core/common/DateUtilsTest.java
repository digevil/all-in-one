package org.digevil.allinone.core.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    public void testConvertGMT2Epoch() {
        System.out.println(DateUtils.convertGMT2Epoch("2024-05-09T16:09:35-06:00"));
    }

}