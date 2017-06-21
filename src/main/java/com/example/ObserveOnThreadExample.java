package com.example;

import rx.Observable;

import java.util.List;

/**
 * Created by tomar on 21/06/17.
 */
public class ObserveOnThreadExample {
    public static void main(String[] args) {

        List<Integer> list =DataGenerator.generateFibbanociList();
       Observable<Integer> observable = Observable.from(list);

       observable.subscribe(

               //OnNExt
               (i) -> {
                   System.out.println("onNext thread enter "+ ThreadUtil.getCurrentThreadNAme());
                   System.out.println(i);
                   System.out.println("onNext thread exit "+ ThreadUtil.getCurrentThreadNAme());
               },
               (t) -> {
                   t.printStackTrace();
               },
               () -> {
                System.out.println("onCompleted");
                }

       );
       System.exit(0);
    }
}
