package com.moonlyte.assignmentmoonlyte.progressHUD;


public class LoaderGenerator {

    public static LoaderView generateLoaderView(int type) {
        return new TwinFishesSpinner();
    }

    public static LoaderView generateLoaderView(String type) {
        return new TwinFishesSpinner();
    }
}

