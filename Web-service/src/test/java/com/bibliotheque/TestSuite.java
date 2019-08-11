package com.bibliotheque;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestBookBusiness.class,
        TestKindBusiness.class,
        TestLoanBusiness.class
})
public class TestSuite {}
