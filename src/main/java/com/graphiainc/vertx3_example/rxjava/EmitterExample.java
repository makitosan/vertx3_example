package com.graphiainc.vertx3_example.rxjava;

import rx.Emitter.BackpressureMode;
import rx.Observable;
import rx.Observer;
import rx.exceptions.OnErrorThrowable.OnNextValue;

public class EmitterExample {
	public static void main(String[] args) throws Exception {
		Observable<String> emt = Observable.create(emitter -> {
			System.out.println("Now");
			emitter.onNext("Good morning.");
			emitter.onNext("It is fine.");
		}, BackpressureMode.BUFFER);
		Observer<String> sysout = new Observer<String>() {

			@Override
			public void onCompleted() {
			}

			@Override
			public void onError(Throwable arg0) {
			}

			@Override
			public void onNext(String arg0) {
				System.out.println(arg0);
			}
		};
		
		Observable<String> hello = Observable.just("hello");
		System.out.println("tt");
		
		Observable<String> merged = Observable.merge(emt, hello).toList().flatMap(f -> hello		);
		// System.out.println(hello == merged);
		
		System.out.println("xx");
		// emt.subscribe(sysout);
		merged.subscribe(sysout);
		Thread.sleep(1000);
	}
}
