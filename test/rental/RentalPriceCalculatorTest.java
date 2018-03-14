package rental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import person.Renter;

public class RentalPriceCalculatorTest {

	RentalPriceCalculator testCalculator;


	@Before
	public void beforeEachTest() {
		testCalculator = new RentalPriceCalculator(true);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIfUnderageAllowed() {
		Renter renter = new Renter(13, 1, false);
		double testDouble = testCalculator.rentalPrice(renter, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIfNewLicenseAllowed() {
		Renter renter = new Renter(25, 0, false);
		double testDouble = testCalculator.rentalPrice(renter, 1);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testIfYoungPersonCanRentClassThree() {
		Renter renter = new Renter(20, 1, false);
		double testDouble = testCalculator.rentalPrice(renter, 3);
	}

	@Test
	public void testIfPriceIncreaseIfCausedAccidentAndIsYoung() {
		Renter renter = new Renter(22, 5, true);
		assertEquals(37, testCalculator.rentalPrice(renter, 1));
	}

	@Test
	public void testIfPriceIncreaseIfYoungAndHighClassVehicle() {
		Renter renter = new Renter(22, 5, false);
		assertEquals(44, testCalculator.rentalPrice(renter, 5));
	}

	@Test
	public void testIfPriceIncreaseIfLicenceHeldLessThanThreeYears() {
		Renter renter = new Renter(20, 2, false);
		assertEquals(26, testCalculator.rentalPrice(renter, 1));
	}
}
