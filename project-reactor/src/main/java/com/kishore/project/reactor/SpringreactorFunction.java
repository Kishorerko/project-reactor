package com.kishore.project.reactor;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SpringreactorFunction {

	public static void main(String[] args) {
		SpringreactorFunction springreactorFunction = new SpringreactorFunction();
		springreactorFunction.sampleFluxMethod().subscribe(next -> System.out.println(next));
		springreactorFunction.sampleMonoMethod().subscribe(next -> System.out.println("Mono is :" + next));
	}

	public Mono<String> sampleMonoMethod() {
		return Mono.just("Armold").log();
	}

	public Flux<String> sampleFluxMethod() {
		return Flux.fromIterable(List.of("Apple", "Banana", "Grape", "Mango")).log();
	}

	// map() operator
	public Flux<String> sampleFluxMap() {
		return Flux.fromIterable(List.of("Apple", "Banana", "Grape", "Mango")).map(String::toUpperCase).log();
	}

	// REACTIVE STREAMS ARE IMMUTABLE
	public Flux<String> sampleFlux_immutable() {
		var nameFlux = Flux.fromIterable(List.of("Apple", "Banana", "Grape", "Mango"));
		nameFlux.map(String::toUpperCase);
		return nameFlux.log();
	}

	// REACTIVE STREAMS ARE IMMUTABLE
	public Flux<String> sampleFluxFilter(int length) {
		return Flux.fromIterable(List.of("Apple", "Banana", "Grape", "Mango")).filter(s -> s.length() > 5)
				.map(s -> s.length() + "-" + s);
	}

	// FLATMAP
	public Flux<String> sampleFluxFlatmap(int length) {
		return Flux.fromIterable(List.of("Apple", "Banana", "Rome", "Mango")).map(String::toUpperCase)
				.filter(s -> s.length() > length).flatMap(s -> splitString(s)).log();
	}

	public Flux<String> splitString(String names) {
		var charArray = names.split("");
		return Flux.fromArray(charArray);
	}

	// FLATMAP WITH ASYN
	public Flux<String> sampleFluxFlatmapAsyn(int length) {
		return Flux.fromIterable(List.of("Apple", "Banana", "Rome", "Mango")).map(String::toUpperCase)
				.filter(s -> s.length() == length).flatMap(s -> splitString_withDelay(s)).log();
	}
	// CONCATMAP
		public Flux<String> sampleFluxConcatMap(int length) {
			return Flux.fromIterable(List.of("Apple", "Banana", "Rome", "Mango"))
					.map(String::toUpperCase)
					.filter(s -> s.length() == length)
					.concatMap(s -> splitString_withDelay(s)).log();
		}
		
	public Flux<String> splitString_withDelay(String names) {
		var charArray = names.split("");
		var delay = new Random().nextInt(1000);
		return Flux.fromArray(charArray).delayElements(Duration.ofMillis(delay));
		
	}

}
