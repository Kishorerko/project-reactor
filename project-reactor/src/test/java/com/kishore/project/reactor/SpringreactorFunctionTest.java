package com.kishore.project.reactor;

import org.junit.jupiter.api.Test;

import reactor.test.StepVerifier;

public class SpringreactorFunctionTest {

	SpringreactorFunction springreactorFunction = new SpringreactorFunction();

	@Test
	void sampleFluxMethod() {

		var namesFlux = springreactorFunction.sampleFluxMethod();
		StepVerifier.create(namesFlux).expectNext("Apple", "Banana", "Grape", "Mango").verifyComplete();
	}

	@Test
	void sampleMonoMethod() {
		var nameMono = springreactorFunction.sampleMonoMethod();
		StepVerifier.create(nameMono).expectNext("Armold")
		.verifyComplete();
	}
	@Test
	void sampleFluxMap() {
		var namesFlux = springreactorFunction.sampleFluxMap();
		StepVerifier.create(namesFlux)
		.expectNext("APPLE", "BANANA", "GRAPE", "MANGO")
		.verifyComplete();
	}
	@Test
	void sampleFlux_immutable() {
		var namesFlux = springreactorFunction.sampleFlux_immutable();
		StepVerifier.create(namesFlux)
		.expectNext("Apple", "Banana", "Grape", "Mango")
		.verifyComplete();
	}
	@Test
	void sampleFluxFilter() {
		int length = 5;
		var namesFlux = springreactorFunction.sampleFluxFilter(length);
		StepVerifier.create(namesFlux)
		.expectNext("6-Banana")
		.verifyComplete();
	}
	@Test
	void sampleFluxFlatmap() {
		int length = 5;
		var namesFlux = springreactorFunction.sampleFluxFlatmap(length);
		StepVerifier.create(namesFlux)
		.expectNext("B","A","N","A","N","A")
		.verifyComplete();
	}
	@Test
	void sampleFluxFlatmapAsyn() {
		int length = 5;
		var namesFlux = springreactorFunction.sampleFluxFlatmapAsyn(length);
		StepVerifier.create(namesFlux)
		//.expectNext("A","P","P","L","E","M","A","N","G","O")
		.expectNextCount(10)
		.verifyComplete();
	}
	@Test
	void sampleFluxConcatMap() {
		int length = 5;
		var namesFlux = springreactorFunction.sampleFluxConcatMap(length);
		StepVerifier.create(namesFlux)
		.expectNext("A","P","P","L","E","M","A","N","G","O")
		//.expectNextCount(10)
		.verifyComplete();
	}
	

}
