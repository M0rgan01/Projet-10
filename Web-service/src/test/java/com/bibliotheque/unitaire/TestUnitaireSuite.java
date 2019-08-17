package com.bibliotheque.unitaire;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UnitTestBookBusiness.class,
        UnitTestLoanBusiness.class,
        UnitTestReservationBusiness.class,
        UnitTestUserBusiness.class,
        UnitTestMailBusiness.class,
        UnitTestKindBusiness.class
})
public class TestUnitaireSuite {}
