package com.graphiainc.vertx3_example.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxExample {
	public static void main(String[] args) throws Exception {
//		
//		Observable.from(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) // 1
//		  .filter(new Func1<Integer, Boolean>() { // 2
//		    @Override
//		    public Boolean call(Integer i) {
//		      return (i % 2) == 0;
//		    }
//		  })
//		  .map(new Func1<Integer, Integer>() {  // 2
//		    @Override
//		    public Integer call(Integer i) {
//		      return i * 10;
//		    }
//		  })
//		  .subscribe(new Observer<Integer>() {  // 3
//		    @Override
//		    public void onNext(Integer integer) {
//		    	System.out.println("Hoge " + integer.toString());
//		    }
//
//		    @Override
//		    public void onCompleted() {
//		    	System.out.println("Hoge completed");
//		    }
//
//		    @Override
//		    public void onError(Throwable e) {
//		    }
//		  });
		
		Observable<Integer> obs = Observable.from(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) // 1
		  .filter(new Func1<Integer, Boolean>() { // 2
		    @Override
		    public Boolean call(Integer i) {
		      return (i % 2) == 0;
		    }
		  })
		  .map(new Func1<Integer, Integer>() {  // 2
		    @Override
		    public Integer call(Integer i) {
		      return i * 10;
		    }
		  });
		
		Observer<Integer> observer1 = new Observer<Integer>() {  // 3
		    @Override
		    public void onNext(Integer integer) {
		    	System.out.println("Hoge " + integer.toString());
		    }

		    @Override
		    public void onCompleted() {
		    	System.out.println("Hoge completed");
		    }

		    @Override
		    public void onError(Throwable e) {
		    }
		  };
		  
			Observer<Integer> observer2 = new Observer<Integer>() {  // 3
			    @Override
			    public void onNext(Integer integer) {
			    	System.out.println("Hage " + integer.toString());
			    }

			    @Override
			    public void onCompleted() {
			    	System.out.println("Hage completed");
			    }

			    @Override
			    public void onError(Throwable e) {
			    }
			  };
			  
			  obs.subscribeOn(Schedulers.newThread()).subscribe(observer1);
			  obs.subscribeOn(Schedulers.newThread()).subscribe(observer2);
//			  obs.subscribe(observer1);
//			  obs.subscribe(observer2);
		  
		Thread.sleep(1000);
		
		Observable<String> greeting = Observable.just("Hello");
		Observer<String> observerGreeting = new Observer<String>() {
			@Override
			public void onCompleted() {
				System.out.println("greeting complete");
			}

			@Override
			public void onError(Throwable arg0) {
			}

			@Override
			public void onNext(String arg0) {
				System.out.println(arg0);
			}
		};
		greeting.subscribe(observerGreeting);
	}

}
