package rental;

import person.Renter;

public class RentalPriceCalculator {

	private final static int AGE_25 = 25;
	private final static int AGE_30 = 30;
	private final static int AGE_21 = 21;
	private final static int AGE_18 = 18;
	private final static int LICENCE_HELD_3 = 3;
	private final static int LICENCE_HELD_1 = 1;
	private final static int MULTIPLY_2 = 2;
	private final static double MULTIPLY_BY_FRACTION = 1.3;
	private final static int VEHICLE_CLASS_2 = 2;
	private final static int PRICE_INCREASE_15 = 15;
	private final static int MAX_PRICE = 1000;

	private boolean primeSeason;

	public RentalPriceCalculator(boolean primeSeason) {
		this.primeSeason = primeSeason;
	}

	public double rentalPrice(Renter renter, int vehicleClass) {

		validateRenter(renter, vehicleClass);

		double rentalprice = renter.getAge();

		if (raisePriceIfVehicleClassLargeAndRenterYoung(renter, vehicleClass)) {
			rentalprice = rentalprice * MULTIPLY_2;
		}

		if (raisePriceIfLicenseHeldLessThanThreeYears(renter)) {
			rentalprice = rentalprice * MULTIPLY_BY_FRACTION;
		}
		
		if (raisePriceIfCausedAccidentAndIsYoung(renter)) {
			rentalprice += PRICE_INCREASE_15;
		}

		if (rentalprice > MAX_PRICE) {
			return MAX_PRICE;
		}

		return rentalprice;
	}

	private boolean raisePriceIfCausedAccidentAndIsYoung(Renter renter) {
		return renter.isCausedAccidentLastYear() && renter.getAge() < AGE_30;
	}

	private boolean raisePriceIfLicenseHeldLessThanThreeYears(Renter renter) {
		return renter.getLicenceHeld() < LICENCE_HELD_3;
	}

	private boolean raisePriceIfVehicleClassLargeAndRenterYoung(Renter renter, int vehicleClass) {
		return vehicleClass >=4 && renter.getAge() <= AGE_25 && isPrimeSeason();
	}

	private void validateRenter(Renter renter, int vehicleClass) {
		if (renter.getAge() < AGE_18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (renter.getAge() <= AGE_21 && vehicleClass > VEHICLE_CLASS_2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		if (renter.getLicenceHeld() < LICENCE_HELD_1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
	}

	public boolean isPrimeSeason() {
		return primeSeason;
	}

	public void setPrimeSeason(boolean primeSeason) {
		this.primeSeason = primeSeason;
	}
}