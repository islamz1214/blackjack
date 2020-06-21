package io.zahid.blackjack;

public class Access {

	boolean newGameAccess;
	boolean betAccess;
	boolean dealAccess;
	boolean hitAccess;
	boolean standAccess;

	public Access() {
		reset();
	}

	public void newGameComplete() {
		newGameAccess = false;
		betAccess = true;
	}

	public void betComplete() {
		betAccess = false;
		dealAccess = true;
	}

	public void dealComplete() {
		dealAccess = false;
		hitAccess = true;
		standAccess = true;
	}

	public void hitComplete() {
		reset();
	}

	public void standComplete() {
		reset();
	}

	public void reset() {
		newGameAccess = true;
		betAccess = false;
		dealAccess = false;
		hitAccess = false;
		standAccess = false;
	}

	public boolean isNewGameAccessible() {
		return newGameAccess;
	}

	public boolean isBetAccessible() {
		return betAccess;
	}

	public boolean isDealAccessible() {
		return dealAccess;
	}

	public boolean isHitAccessible() {
		return hitAccess;
	}

	public boolean isStandAccessible() {
		return standAccess;
	}
}
