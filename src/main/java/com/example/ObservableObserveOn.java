package com.example;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;

/**
 * Created by tomar on 21/06/17.
 */
public class ObservableObserveOn {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = DataGenerator.generateFibbanociList();
        Observable<Integer> observable = Observable.from(list);

        Object monitor = new Object();
        synchronized (monitor) {

            observable.observeOn(Schedulers.io())
                    .subscribe(

                            //OnNExt
                            (i) -> {
                                System.out.println("onNext thread enter " + ThreadUtil.getCurrentThreadNAme());
                                System.out.println(i);
                                System.out.println("onNext thread exit " + ThreadUtil.getCurrentThreadNAme()+"\n");
                            },
                            (t) -> {
                                t.printStackTrace();
                            },
                            () -> {
                                System.out.println("onCompleted");
                            }

                    );
            ThreadUtil.wait(monitor);
        }

        System.exit(0);
    }
}
