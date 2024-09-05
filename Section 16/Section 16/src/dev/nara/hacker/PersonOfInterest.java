package dev.nara.hacker;

import dev.nara.immutableclasses.PersonImmutable;

public class PersonOfInterest extends PersonImmutable {

	public PersonOfInterest(PersonImmutable person) {
		super(person);
	}
}
