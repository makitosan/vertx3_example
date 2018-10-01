package com.graphiainc.vertx3_example.rxjava;

import rx.Observable;
import rx.Observer;

public class RxExample2 {
	public static void main(String[] args) {
		Observable<String> greeting = Observable.just("Hello");
		Observable<String> bye = Observable.just("Good bye");
		Observable<String> yes = Observable.just("YES");
		
		Observable<String> merged = Observable.merge(greeting, bye).toList().flatMap(str -> {
			System.out.println("in " + str);
			return yes;
			});
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
		
		merged.subscribe(sysout);
		
		Observable<String> merged2 = Observable.merge(greeting, bye);
		merged2.subscribe(sysout);
	}
}
